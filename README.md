# Microservice-Formacion
 Java SrpingBoot microservices

Three little webservices that conect to a MySQL Data Base and show the datas on a front end view with JavaScript and AngularJS with AJAX.

## MicroService
This service connect to the Data Base and collect all data from courses table, and add new courses

One course has an student object

## MicroClient
This service connect to the previous microservice and collect the list of existing courses and all student from a course

## FrontEnd Client
In this frontend, you can select a course and see what students are inscripted. This service connect with the previous service, and collect all the information.
