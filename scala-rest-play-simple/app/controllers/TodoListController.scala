package controllers

import models.{NewTodoListItem, TodoListItem}
import play.api.libs.json._
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

import javax.inject._
import scala.collection.mutable

@Singleton
class TodoListController @Inject()(val controllerComponents: ControllerComponents)
  extends BaseController {
  implicit val todoListJson = Json.format[TodoListItem]
  implicit val newTodoListJson = Json.format[NewTodoListItem]

  private val todoList = new mutable.ListBuffer[TodoListItem]()
  todoList += TodoListItem(1, "Learn Scala", false)
  todoList += TodoListItem(2, "Use Play framework", false)
  todoList += TodoListItem(3, "Help Ef", false)
  todoList += TodoListItem(4, "Help Em", false)
  todoList += TodoListItem(5, "Cook", false)
  todoList += TodoListItem(6, "Eat", false)
  todoList += TodoListItem(7, "Run", false)
  todoList += TodoListItem(8, "Shower", false)

  // curl localhost:9000/api/v1/todo
  def getAll(): Action[AnyContent] = Action {
    if (todoList.isEmpty) {
      NoContent
    } else {
      Ok(Json.toJson(todoList))
    }
  }

  // curl localhost:9000/api/v1/todo/1
  def getById(itemId: Long): Action[AnyContent] = Action {
    val foundItem = todoList.find(_.id == itemId)
    foundItem match {
      case Some(item) => Ok(Json.toJson(item))
      case None => NotFound(s"ToDo item $itemId is not found")
    }
  }

  // curl -X PUT localhost:9000/api/v1/todo/done/1
  def markAsDonePut(itemId: Long): Action[AnyContent] = Action {
    val foundItem = todoList.find(_.id == itemId)
    foundItem match {
      case Some(item) =>
        val newItem = item.copy(isItDone = true)
        //todoList.dropWhileInPlace(_.id == itemId)   // this one has a bug
        todoList -= item
        todoList += newItem
        Accepted(Json.toJson(newItem))
      case None => NotFound
    }
  }

  // curl -X PATCH localhost:9000/api/v1/todo/done/1
  def markAsDonePatch(itemId: Long): Action[AnyContent] = Action {
    val foundItem = todoList.find(_.id == itemId)
    foundItem match {
      case Some(item) =>
        val newItem = item.copy(isItDone = true)
        //todoList.dropWhileInPlace(_.id == itemId)   // this one has a bug
        todoList -= item
        todoList += newItem
        Accepted(Json.toJson(newItem))
      case None => NotFound
    }
  }

  // curl -X DELETE localhost:9000/api/v1/todo/done
  // this function only deletes Done items
  def deleteAllDone(): Action[AnyContent] = Action {
    todoList.filterInPlace(_.isItDone == false)
    Accepted(s"All completed ToDo items have been deleted")
  }

  // curl -X DELETE localhost:9000/api/v1/todo/888
  // this function only deletes Done items
  def deleteById(itemId: Long): Action[AnyContent] = Action {
    todoList.filterInPlace(_.id != itemId)
    Accepted(s"The ToDo item $itemId has been deleted")
  }

  // curl -v -d '{"description": "some new item"}' -H 'Content-Type: application/json' -X POST localhost:9000/api/v1/todo
  def addNewItem(): Action[AnyContent] = Action { implicit request =>
    val content = request.body
    val jsonObject = content.asJson
    val todoListItem: Option[NewTodoListItem] =
      jsonObject.flatMap(
        Json.fromJson[NewTodoListItem](_).asOpt
      )

    todoListItem match {
      case Some(newItem) =>
        val nextId = todoList.map(_.id).max + 1
        val toBeAdded = TodoListItem(nextId, newItem.description, false)
        todoList += toBeAdded
        Created(Json.toJson(toBeAdded))
      case None =>
        BadRequest
    }
  }

  // change to UUID
}