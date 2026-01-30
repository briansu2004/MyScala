# WSL/Ubuntu on Win 11

- [After WSL installation](#after-wsl-installation)
- [After Ubuntu installation](#after-ubuntu-installation)
  - [**Step 1: Open WSL**](#step-1-open-wsl)
  - [**Step 2: Update your Linux environment**](#step-2-update-your-linux-environment)
  - [**Step 3: Install Java (Hadoop requires Java 8+ or 11)**](#step-3-install-java-hadoop-requires-java-8-or-11)
  - [**Step 4: Install Scala 3.8.1**](#step-4-install-scala-381)
  - [**Step 5: Install Hadoop 3.3.6**](#step-5-install-hadoop-336)
  - [**Step 6: Running Hadoop**](#step-6-running-hadoop)
  - [✅ Tips for WSL](#-tips-for-wsl)

## After WSL installation

## After Ubuntu installation

Since you have WSL installed on Windows 11, you can essentially use it as a Linux environment right inside Windows. Let’s go **step by step** for your use case with **Hadoop 3.3.6** and **Scala 3.8.1**. I’ll assume you’re using **WSL 2** with Ubuntu (the default Linux distro is fine).

---

### **Step 1: Open WSL**

1. Press **Win + S** → type `WSL` or `Ubuntu` → hit Enter.
2. This will open a Linux terminal where you can run Linux commands.

---

### **Step 2: Update your Linux environment**

Always good to start fresh:

```bash
sudo apt update
sudo apt upgrade -y
```

---

### **Step 3: Install Java (Hadoop requires Java 8+ or 11)**

```bash
sudo apt install openjdk-11-jdk -y
```

Check Java version:

```bash
java -version
```

---

### **Step 4: Install Scala 3.8.1**

You can download it from official site or use `cs` (Coursier) for easy installation.

**Option 1: Using Coursier**

```bash
curl -fLo cs https://git.io/coursier-cli-linux
chmod +x cs
./cs setup
```

This will install Scala, sbt, and more. Check version:

```bash
scala -version
```

**Option 2: Manual download**

```bash
wget https://downloads.lightbend.com/scala/3.3.1/scala-3.3.1.tgz
tar xvf scala-3.3.1.tgz
sudo mv scala-3.3.1 /opt/scala
export PATH=$PATH:/opt/scala/bin
scala -version
```

*(Adjust the version URL for 3.8.1 if it’s released. Scala 3.8.x might be new, check official Scala website.)*

---

### **Step 5: Install Hadoop 3.3.6**

1. Download Hadoop:

```bash
wget https://downloads.apache.org/hadoop/common/hadoop-3.3.6/hadoop-3.3.6.tar.gz
tar -xvzf hadoop-3.3.6.tar.gz
sudo mv hadoop-3.3.6 /opt/hadoop
```

2. Configure environment variables:

```bash
nano ~/.bashrc
```

Add at the end:

```bash
export HADOOP_HOME=/opt/hadoop
export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
export HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
```

Save and reload:

```bash
source ~/.bashrc
```

3. Test Hadoop:

```bash
hadoop version
```

It should show **3.3.6**.

---

### **Step 6: Running Hadoop**

* For **single-node pseudo-distributed mode** (good for learning/testing):

1. Edit `core-site.xml` and `hdfs-site.xml` in `$HADOOP_HOME/etc/hadoop` to configure directories and settings.
2. Format the NameNode:

```bash
hdfs namenode -format
```

3. Start Hadoop daemons:

```bash
start-dfs.sh
start-yarn.sh
```

4. Verify HDFS:

```bash
hdfs dfs -ls /
```

---

### ✅ Tips for WSL

* Access Windows files: `/mnt/c/Users/YourName/...`
* For GUI apps like Hadoop Web UI, open WSL in **Windows localhost**. For example, Hadoop UI is usually `http://localhost:9870`.

---

If you want, I can make a **ready-to-run WSL script** that installs **Java, Scala 3.8.1, and Hadoop 3.3.6** with all environment variables set, so you just run it once and everything is ready.

Do you want me to do that?
