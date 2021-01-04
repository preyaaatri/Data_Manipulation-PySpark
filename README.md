<p align="center">
  <a href="" rel="noopener">
 <img width=200px height=200px src="https://i.imgur.com/6wj0hh6.jpg" alt="Project logo"></a>
</p>

<h3 align="center">Scala Assignment</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![GitHub Issues](https://img.shields.io/github/issues/kylelobo/The-Documentation-Compendium.svg)](https://github.com/preyaaatri/scalaAssignment/issues)
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/kylelobo/The-Documentation-Compendium.svg)](https://github.com/preyaaatri/scalaAssignment/pulls)

</div>

---

<p align="center"> This is a simple scala project for Data Manipulation using SparkSQL
    <br> 
</p>

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Deployment](#deployment)
- [Usage](#usage)
- [Built Using](#built_using)
- [Authors](#authors)
- [Acknowledgments](#acknowledgement)

## 🧐 About <a name = "about"></a>

The purpose of this project was to simplify the environment setup for scala, spark, python and R.

## 🏁 Getting Started <a name = "getting_started"></a>

To run this project you need basic understanding of Jupyter and Scala

### Prerequisites

you need to install docker to run this project as it spinnes a jupyter project setup


### Installing

First you need to setup the environment by running the makefile


``` make run ```

The above command will spin up a docker container and provice you the link to use jupyter
Once you open the jupyter link you can open ```assignment.ipynb```
By default the file will be opened in ``` Python 3 ``` kernal. Please change the kernal to ``` spylon-kernal```



## 🎈 Usage <a name="usage"></a>

Since the code is running inside a docker container, the data is not persistant. The soule purpose of this setup is to get your environment setup for running a scala spart project in jupyter. 

## 🚀 Deployment <a name = "deployment"></a>

To deploy the project, you can run you code on the jupyter tool and save the file inside app folder to reuse it.

## ⛏️ Built Using <a name = "built_using"></a>

- [Jupyter](https://jupyter.org/) - Development tool
- [Docker](https://www.docker.com/) - Environment virtualization
- [Scala](https://www.scala-lang.org/) - Programming language
- [Spark](https://nodejs.org/en/) - Cluster-computing framework

## ✍️ Authors <a name = "authors"></a>

- [@patri](https://github.com/preyaaatri) - Idea & Initial work


## 🎉 Acknowledgements <a name = "acknowledgement"></a>

- Hat tip to anyone whose code was used
- Inspiration
- References
