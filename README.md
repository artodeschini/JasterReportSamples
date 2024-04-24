# Jasper Report open StandAlone (iReport) helpers

Este repositorio mostra como trabalhar com Jasper Report e applicacoes

O demo aqui executa um jar que irá utilizar JasperView com swing do java, pode ser utilziado com qualquer quer outra
interface

O Objetivo aqui é de demostrar a utilização de JRDataSource como fonte de dados para os relatorios bem como utilziar
de maneira dinamica os relatorios apartir dos arquivos jrxml e gerar pdf

## requirements

* iReport 5.6.0
* Java 11 +
* Maven 3.6+

## iReport 

[download](https://sourceforge.net/projects/ireport/files/iReport/iReport-5.6.0/)

## maven how to execute

```bash
mvn clean install
java -jar target/JasterReport-1.0.0.jar
```