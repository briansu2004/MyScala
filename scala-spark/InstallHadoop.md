# Hadoop on Win 11

- [✅ Option 1 (Most common): Download “Hadoop for Windows” package (winutils + hadoop.dll)](#-option-1-most-common-download-hadoop-for-windows-package-winutils--hadoopdll)
  - [Steps](#steps)
- [✅ Option 2 (Recommended \& safer): Install Hadoop via Chocolatey](#-option-2-recommended--safer-install-hadoop-via-chocolatey)
  - [1) Install Chocolatey (if you don’t have it)](#1-install-chocolatey-if-you-dont-have-it)
  - [2) Install Hadoop](#2-install-hadoop)
- [Verify it works](#verify-it-works)
  - [Important Note](#important-note)

To get **hadoop.dll** on Windows 11, you basically have **2 reliable ways** (because Hadoop does not officially ship Windows binaries anymore).

---

## ✅ Option 1 (Most common): Download “Hadoop for Windows” package (winutils + hadoop.dll)

You need a package that contains BOTH:

- `winutils.exe`
- `hadoop.dll`

### Steps

1. Download a Windows Hadoop binary package (Hadoop 3.x).

   - Search keywords in Google:
     **“hadoop.dll winutils.exe Hadoop 3.3.6 windows”**
     or
     **“winutils hadoop.dll github”**

2. After download, extract and you should see:

```md
hadoop-3.x.x\
  bin\
    winutils.exe
    hadoop.dll
```

1. Copy them to:

```md
C:\hadoop\bin\
```

So you end up with:

```md
C:\hadoop\bin\winutils.exe
C:\hadoop\bin\hadoop.dll
```

---

## ✅ Option 2 (Recommended & safer): Install Hadoop via Chocolatey

This is the cleanest way to avoid random DLL downloads.

### 1) Install Chocolatey (if you don’t have it)

Open **PowerShell as Administrator** and run:

```powershell
Set-ExecutionPolicy Bypass -Scope Process -Force
iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
```

Close PowerShell and reopen.

### 2) Install Hadoop

```powershell
choco install hadoop -y
```

Then check where it installed:

```powershell
where winutils
```

It should point to something like:

```md
C:\ProgramData\chocolatey\lib\hadoop\tools\hadoop-...\bin\winutils.exe
```

And in the same folder you should find:

```md
hadoop.dll
```

---

## Verify it works

After you place the DLL correctly, open a **new CMD** and run:

```bat
set HADOOP_HOME=C:\hadoop
set PATH=%PATH%;%HADOOP_HOME%\bin
winutils.exe ls C:\
```

If this works, Spark will stop throwing:

`NativeIO$Windows.access0`

---

### Important Note

If you already downloaded `winutils.exe` but **no hadoop.dll**, then you downloaded an incomplete package. Spark needs **both**.

---

If you want, I can tell you exactly which Hadoop version matches your Spark 3.5.0 setup best, and what folder structure Spark expects on Windows.
