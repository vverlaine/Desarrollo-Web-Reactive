drop database cine;

create database cine;

use cine;

create table calificacion_pelicula(
id int primary key auto_increment
,calificacion varchar(25)
,observacion varchar(255)
);

create table lenguaje(
id int primary key auto_increment
,lenguaje varchar(25)
,observacion varchar(255)
);

create table clasificacion_pelicula(
id int primary key auto_increment
,clasificacion varchar(25)
,observacion varchar(255)
);

create table genero(
id int primary key auto_increment
,genero varchar(25)
,observacion varchar(255)
);


create table subtitulos(
id int primary key auto_increment
,subtitulo varchar(25)
,observaciones varchar(255)
);

create table pelicula(
id int primary key auto_increment
,titulo_original varchar(50)
,id_genero int
,id_lenguaje int
,id_subtitulo int
,fecha_produccion datetime
,fecha_estreno datetime
,url_pelicula varchar(255)
,duracion time
,id_clasificacion int
,resumen varchar(255)

,foreign key (id_genero) references genero (id)
on delete cascade
on update cascade

,foreign key (id_lenguaje) references lenguaje (id)
on delete cascade
on update cascade

,foreign key (id_subtitulo) references subtitulos (id)
on delete cascade
on update cascade

,foreign key (id_clasificacion) references clasificacion_pelicula (id)
on delete cascade
on update cascade

);

create table reparto(
id int primary key auto_increment
,nombre varchar(25)
,apellido varchar(25)
,id_pelicula int

,foreign key (id_pelicula) references pelicula (id)
on delete cascade
on update cascade
);

create table tipo_reaccion(
id int primary key
,tipo_reaccion varchar(25)
);


create table opinion_pelicula(
id_registro int primary key auto_increment
,id_pelicula int
,nombre varchar(50)
,apellido varchar(50)
,fecha_registro datetime
,comentarios varchar(255)
,id_calificacion int
,id_tipo_reaccion int

,foreign key (id_pelicula) references pelicula (id)
on delete cascade
on update cascade

,foreign key (id_calificacion) references calificacion_pelicula (id)
on delete cascade
on update cascade

,foreign key (id_tipo_reaccion) references tipo_reaccion (id)
);
