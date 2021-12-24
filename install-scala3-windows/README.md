# Install Scala 3 in Windows

## Install Coursier

```dos
> bitsadmin /transfer cs-cli https://git.io/coursier-cli-windows-exe "%cd%\cs.exe"
> .\cs --help
```

```dos
DISPLAY: 'cs-cli' TYPE: DOWNLOAD STATE: TRANSFERRED
PRIORITY: NORMAL FILES: 1 / 1 BYTES: 58251264 / 58251264 (100%)
Transfer complete.

23/12/2021  05:49 PM        58,251,264 cs.exe
```

or

https://git.io/coursier-cli-windows-exe

## Install Scala 3 with Coursier

```dos
cs install scala3-compiler
cs install scala3
```

```dos
c:\tmp>cs install scala3-compiler
https://repo1.maven.org/maven2/io/get-coursier/apps/maven-metadata.xml
  100.0% [##########] 2.1 KiB (5.7 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-compiler_3/maven-metadata.xml
  100.0% [##########] 11.6 KiB (196.7 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-compiler_3/3.1.0/scala3-compiler_3-3.1.0.pom
  100.0% [##########] 4.8 KiB (106.3 KiB / s)
https://repo1.maven.org/maven2/org/jline/jline-terminal-jna/3.19.0/jline-terminal-jna-3.19.0.pom
  100.0% [##########] 1.8 KiB (31.0 KiB / s)
https://repo1.maven.org/maven2/org/jline/jline-terminal/3.19.0/jline-terminal-3.19.0.pom
  100.0% [##########] 1.2 KiB (12.5 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/modules/scala-asm/9.1.0-scala-1/scala-asm-9.1.0-scala-1.pom
  100.0% [##########] 1.5 KiB (14.8 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/tasty-core_3/3.1.0/tasty-core_3-3.1.0.pom
  100.0% [##########] 3.5 KiB (30.0 KiB / s)
https://repo1.maven.org/maven2/org/jline/jline-reader/3.19.0/jline-reader-3.19.0.pom
  100.0% [##########] 1.2 KiB (7.5 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-interfaces/3.1.0/scala3-interfaces-3.1.0.pom
  100.0% [##########] 3.4 KiB (32.3 KiB / s)
https://repo1.maven.org/maven2/org/scala-sbt/compiler-interface/1.3.5/compiler-interface-1.3.5.pom
  100.0% [##########] 2.8 KiB (17.8 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.1.0/scala3-library_3-3.1.0.pom
  100.0% [##########] 3.6 KiB (42.3 KiB / s)
https://repo1.maven.org/maven2/org/jline/jline-parent/3.19.0/jline-parent-3.19.0.pom
  100.0% [##########] 23.0 KiB (426.0 KiB / s)
https://repo1.maven.org/maven2/org/sonatype/oss/oss-parent/9/oss-parent-9.pom
  100.0% [##########] 6.4 KiB (145.8 KiB / s)
https://repo1.maven.org/maven2/com/google/protobuf/protobuf-java/3.7.0/protobuf-java-3.7.0.pom
  100.0% [##########] 5.2 KiB (86.4 KiB / s)
https://repo1.maven.org/maven2/org/scala-sbt/util-interface/1.3.0/util-interface-1.3.0.pom
  100.0% [##########] 2.7 KiB (45.2 KiB / s)
https://repo1.maven.org/maven2/net/java/dev/jna/jna/5.3.1/jna-5.3.1.pom
  100.0% [##########] 1.5 KiB (19.3 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.6/scala-library-2.13.6.pom
  100.0% [##########] 1.6 KiB (19.5 KiB / s)
https://repo1.maven.org/maven2/com/google/protobuf/protobuf-parent/3.7.0/protobuf-parent-3.7.0.pom
  100.0% [##########] 7.1 KiB (108.7 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-interfaces/3.1.0/scala3-interfaces-3.1.0.jar
  100.0% [##########] 3.4 KiB (57.4 KiB / s)
https://repo1.maven.org/maven2/org/jline/jline-terminal-jna/3.19.0/jline-terminal-jna-3.19.0.jar
  100.0% [##########] 61.7 KiB (514.2 KiB / s)
https://repo1.maven.org/maven2/org/jline/jline-reader/3.19.0/jline-reader-3.19.0.jar
  100.0% [##########] 166.6 KiB (1.5 MiB / s)
https://repo1.maven.org/maven2/org/scala-lang/tasty-core_3/3.1.0/tasty-core_3-3.1.0.jar
  100.0% [##########] 71.8 KiB (1.3 MiB / s)
https://repo1.maven.org/maven2/org/scala-sbt/util-interface/1.3.0/util-interface-1.3.0.jar
  100.0% [##########] 2.5 KiB (42.6 KiB / s)
https://repo1.maven.org/maven2/net/java/dev/jna/jna/5.3.1/jna-5.3.1.jar
  100.0% [##########] 1.4 MiB (4.8 MiB / s)
https://repo1.maven.org/maven2/org/scala-sbt/compiler-interface/1.3.5/compiler-interface-1.3.5.jar
  100.0% [##########] 90.3 KiB (799.1 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/modules/scala-asm/9.1.0-scala-1/scala-asm-9.1.0-scala-1.jar
  100.0% [##########] 304.8 KiB (1.8 MiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.1.0/scala3-library_3-3.1.0.jar
  100.0% [##########] 1.1 MiB (3.6 MiB / s)
https://repo1.maven.org/maven2/org/jline/jline-terminal/3.19.0/jline-terminal-3.19.0.jar
  100.0% [##########] 223.1 KiB (2.5 MiB / s)
https://repo1.maven.org/maven2/com/google/protobuf/protobuf-java/3.7.0/protobuf-java-3.7.0.jar
  100.0% [##########] 1.4 MiB (8.8 MiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.6/scala-library-2.13.6.jar
  100.0% [##########] 5.7 MiB (10.9 MiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-compiler_3/3.1.0/scala3-compiler_3-3.1.0.jar
  100.0% [##########] 16.2 MiB (10.0 MiB / s)
Wrote scala3-compiler
Warning: C:\Users\...\AppData\Local\Coursier\data\bin is not in your PATH
```

```dos
c:\tmp>cs install scala3
https://repo1.maven.org/maven2/org/scala-lang/scala3-compiler_3/maven-metadata.xml
  No new update since 2021-12-22 23:22:00
https://repo1.maven.org/maven2/org/scala-lang/scala3-compiler_3/maven-metadata.xml
  No new update since 2021-12-22 23:22:00
https://repo1.maven.org/maven2/org/scala-lang/scala3-compiler_3/3.1.2-RC1-bin-20211222-c94b333-NIGHTLY/scala3-compiler_3-3.1.2-RC1-bin-20211222-c94b333-NIGHTLY.pom
  100.0% [##########] 4.9 KiB (87.7 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/tasty-core_3/3.1.2-RC1-bin-20211222-c94b333-NIGHTLY/tasty-core_3-3.1.2-RC1-bin-20211222-c94b333-NIGHTLY.pom
  100.0% [##########] 3.7 KiB (63.9 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-interfaces/3.1.2-RC1-bin-20211222-c94b333-NIGHTLY/scala3-interfaces-3.1.2-RC1-bin-20211222-c94b333-NIGHTLY.pom
  100.0% [##########] 3.5 KiB (30.1 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.1.2-RC1-bin-20211222-c94b333-NIGHTLY/scala3-library_3-3.1.2-RC1-bin-20211222-c94b333-NIGHTLY.pom
  100.0% [##########] 3.7 KiB (31.7 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-interfaces/3.1.2-RC1-bin-20211222-c94b333-NIGHTLY/scala3-interfaces-3.1.2-RC1-bin-20211222-c94b333-NIGHTLY.jar
  100.0% [##########] 3.5 KiB (49.0 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/tasty-core_3/3.1.2-RC1-bin-20211222-c94b333-NIGHTLY/tasty-core_3-3.1.2-RC1-bin-20211222-c94b333-NIGHTLY.jar
  100.0% [##########] 72.1 KiB (1015.8 KiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.1.2-RC1-bin-20211222-c94b333-NIGHTLY/scala3-library_3-3.1.2-RC1-bin-20211222-c94b333-NIGHTLY.jar
  100.0% [##########] 1.2 MiB (4.4 MiB / s)
https://repo1.maven.org/maven2/org/scala-lang/scala3-compiler_3/3.1.2-RC1-bin-20211222-c94b333-NIGHTLY/scala3-compiler_3-3.1.2-RC1-bin-20211222-c94b333-NIGHTLY.jar
  100.0% [##########] 16.4 MiB (18.4 MiB / s)
Wrote scala3
Warning: C:\Users\...\AppData\Local\Coursier\data\bin is not in your PATH
```

## Edit PATH environment

Add "C:\Users\...\AppData\Local\Coursier\data\bin" to PATH

## Test Scala 3

```dos
scala3
```

```dos
c:\tmp>scala3
Welcome to Scala 3.1.2-RC1-bin-20211222-c94b333-NIGHTLY-git-c94b333 (16.0.1, Java Java HotSpot(TM) 64-Bit Server VM).
Type in expressions for evaluation. Or try :help.

scala> :help
The REPL has several commands available:

:help                    print this summary
:load <path>             interpret lines in a file
:quit                    exit the interpreter
:type <expression>       evaluate the type of the given expression
:doc <expression>        print the documentation for the given expression
:imports                 show import history
:reset                   reset the repl to its initial state, forgetting all session entries
:settings <options>      update compiler options, if possible


scala> :quit
```

## Install Scala 3 with GitHub download

https://github.com/lampepfl/dotty/releases/tag/3.1.0
