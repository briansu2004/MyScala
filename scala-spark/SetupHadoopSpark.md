# Set up Spark in Windows 11

- [Env](#env)
- [Hadoop](#hadoop)
- [Winutils](#winutils)

## Env

- HADOOP_HOME : c:\Hadoop
- Path : %PATH%;%HADOOP_HOME%\bin

## Hadoop

Hadoop 3.3.6 windows

<https://www.apache.org/dyn/closer.cgi/hadoop/common/hadoop-3.3.6/hadoop-3.3.6.tar.gz>

Put `hadoop.dll` in %HADOOP_HOME%\bin

## Winutils

<https://github.com/cdarlint/winutils/tree/master/hadoop-3.3.6/bin>

Put `winutils.exe` in %HADOOP_HOME%\bin
