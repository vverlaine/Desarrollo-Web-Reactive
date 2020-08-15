/*drop database cine;*/

create database cine;

use cine;

create table calificacion_pelicula(
id int primary key auto_increment
,calificacion varchar(25)
,observacion varchar(255)
);

create table pais(
id int primary key auto_increment
,pais varchar(25)
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

create table rol(
id int primary key auto_increment
,rol varchar(25)
,observacion varchar(255)
);

create table cine(
id int primary key auto_increment
,nombre_cine varchar(59)
,direccion varchar(100)
,telefono varchar(12)
);


create table sala(
id int primary key auto_increment
,nombre_sala varchar(25)
,id_cine int
,numero_butacas int
,foreign key (id_cine) references cine (id)
on delete cascade
on update cascade
);

create table subtitulos(
id int primary key auto_increment
,subtitulo varchar(25)
,observaciones varchar(255)
);

create table pelicula(
id int primary key auto_increment
,titulo_distribucion varchar(50)
,titulo_original varchar(50)
,id_genero int
,id_lenguaje int
,id_subtitulo int
,id_pais_origen int
,fecha_produccion datetime
,fecha_estreno datetime
,url_pelicula varchar(100)
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

,foreign key (id_pais_origen) references pais (id)
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
,id_pais_nacimiento int
,id_pelicula int

,foreign key (id_pais_nacimiento) references pais (id)
on delete cascade
on update cascade

,foreign key (id_pelicula) references pelicula (id)
on delete cascade
on update cascade
);

create table personaje(
id_personaje int primary key auto_increment
,id_actor int
,nombre_personaje varchar(50)
,id_pelicula int

,foreign key (id_actor) references reparto (id)
on delete cascade
on update cascade

,foreign key (id_pelicula) references pelicula (id)
on delete cascade
on update cascade
);

create table cartelera(
id_cine int
,id_sala int
,id_pelicula int
,fecha_funcion datetime
,hora_funcion time

,primary key (id_cine, id_sala, hora_funcion)

,foreign key (id_cine) references cine (id)
on delete cascade
on update cascade

,foreign key (id_sala) references sala (id)
on delete cascade
on update cascade

,foreign key (id_pelicula) references pelicula (id)
on delete cascade
on update cascade

);

create table opinion_pelicula(
id_registro int primary key auto_increment
,id_pelicula int
,nombre varchar(50)
,apellido varchar(50)
,fecha_registro datetime
,comentarios varchar(255)
,id_calificacion int

,foreign key (id_pelicula) references pelicula (id)
on delete cascade
on update cascade

,foreign key (id_calificacion) references calificacion_pelicula (id)
on delete cascade
on update cascade
);
