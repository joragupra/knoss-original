--Crea la tabla de categorķas disponibles de libros
CREATE TABLE "SCOTT"."JORAGUPRA_CATEGORIAS"
(
"ID_CATEGORIA" VARCHAR2 (6) NOT NULL,
"NOMBRE" VARCHAR2 (20) NOT NULL
)
;
ALTER TABLE "SCOTT"."JORAGUPRA_CATEGORIAS"
ADD CONSTRAINT "JORAGUPRA_CATEGORIAS_PK1" PRIMARY KEY
(
"ID_CATEGORIA"
)
 ENABLE
;
ALTER TABLE "SCOTT"."JORAGUPRA_CATEGORIAS"
ADD CONSTRAINT "JORAGUPRA_CATEGORIAS_UK1" UNIQUE
(
"NOMBRE"
)
 ENABLE
;

--Crea la tabla de autores
CREATE TABLE "SCOTT"."JORAGUPRA_AUTORES"
(
"ID_AUTOR" NUMBER NOT NULL,
"NOMBRE" VARCHAR2 (40) NOT NULL,
"APELLIDO1" VARCHAR2 (40) NOT NULL,
"APELLIDO2" VARCHAR2 (40),
"FECHA_NAC" NUMBER,
"FECHA_DEF" NUMBER,
"BIOGRAFIA" VARCHAR2 (900)
)
;
ALTER TABLE "SCOTT"."JORAGUPRA_AUTORES"
ADD CONSTRAINT "JORAGUPRA_AUTORES_PK1" PRIMARY KEY
(
"ID_AUTOR"
)
 ENABLE
;

--Crea la tabla de editoriales
CREATE TABLE "SCOTT"."JORAGUPRA_EDITORIALES"
(
"ID_EDITORIAL" VARCHAR2 (6) NOT NULL,
"NOMBRE" VARCHAR2 (40) NOT NULL
)
;
ALTER TABLE "SCOTT"."JORAGUPRA_EDITORIALES"
ADD CONSTRAINT "JORAGUPRA_EDITORIALES_PK1" PRIMARY KEY
(
"ID_EDITORIAL"
)
 ENABLE
;

--Crea la tabla de libros
CREATE TABLE "SCOTT"."JORAGUPRA_LIBROS"
(
"ID_LIBRO" NUMBER NOT NULL,
"TITULO" VARCHAR2 (100) NOT NULL,
"ID_AUTOR" NUMBER NOT NULL,
"ID_EDITORIAL" VARCHAR2 (6) NOT NULL,
"ID_CATEGORIA" VARCHAR2 (6) NOT NULL,
"ISBN" VARCHAR2 (15) NOT NULL,
"ENCUADERNACION" VARCHAR2 (20),
"PAGINAS" NUMBER,
"IDIOMA" VARCHAR2 (20),
"PRECIO" FLOAT (10) NOT NULL,
"RESUMEN" VARCHAR2 (3000)
)
;
ALTER TABLE "SCOTT"."JORAGUPRA_LIBROS"
ADD CONSTRAINT "JORAGUPRA_LIBROS_PK1" PRIMARY KEY
(
"ID_LIBRO"
)
 ENABLE
;
ALTER TABLE "SCOTT"."JORAGUPRA_LIBROS"
ADD CONSTRAINT "JORAGUPRA_LIBROS_FK1" FOREIGN KEY
(
"ID_AUTOR"
)
REFERENCES "JORAGUPRA_AUTORES"
(
"ID_AUTOR"
) ENABLE
;
ALTER TABLE "SCOTT"."JORAGUPRA_LIBROS"
ADD CONSTRAINT "JORAGUPRA_LIBROS_FK2" FOREIGN KEY
(
"ID_EDITORIAL"
)
REFERENCES "JORAGUPRA_EDITORIALES"
(
"ID_EDITORIAL"
) ENABLE
;
ALTER TABLE "SCOTT"."JORAGUPRA_LIBROS"
ADD CONSTRAINT "JORAGUPRA_LIBROS_FK3" FOREIGN KEY
(
"ID_CATEGORIA"
)
REFERENCES "JORAGUPRA_CATEGORIAS"
(
"ID_CATEGORIA"
) ENABLE
;

--Crea la tabla de usuarios del sistema
CREATE TABLE "SCOTT"."JORAGUPRA_USUARIOS"
(
"USERNAME" VARCHAR2 (20) NOT NULL,
"PASSWORD" VARCHAR2 (40) NOT NULL,
"NOMBRE" VARCHAR2 (50) NOT NULL,
"APELLIDOS" VARCHAR2 (150)  NOT NULL,
"DIRECCION" VARCHAR2 (150) NOT NULL,
"POBLACION" VARCHAR2 (50) NOT NULL,
"PROVINCIA" VARCHAR2 (30) NOT NULL,
"CP" VARCHAR2 (10) NOT NULL,
"PAIS" VARCHAR2 (15) NOT NULL,
"EMAIL" VARCHAR2 (50) NOT NULL,
"TELEFONO" VARCHAR2 (15) NOT NULL
)
;
ALTER TABLE "SCOTT"."JORAGUPRA_USUARIOS"
ADD CONSTRAINT "JORAGUPRA_USUARIOS_PK1" PRIMARY KEY
(
"USERNAME"
)
 ENABLE
;

--Crea la tabla de pedidos
CREATE TABLE "SCOTT"."JORAGUPRA_PEDIDOS"
(
"ID_PEDIDO" NUMBER NOT NULL,
"USERNAME" VARCHAR2 (20) NOT NULL,
"FORMA_PAGO" VARCHAR2 (16) NOT NULL,
"NUM_TARJETA" NUMBER (16),
"FECHA" NUMBER (20) NOT NULL,
"ESTADO" VARCHAR2 (10) NOT NULL,
"DIRECCION" VARCHAR2 (150) NOT NULL,
"POBLACION" VARCHAR2 (50) NOT NULL,
"PROVINCIA" VARCHAR2 (30) NOT NULL,
"CP" VARCHAR2 (10) NOT NULL,
"PAIS" VARCHAR2 (15) NOT NULL,
"MAS_INFO" VARCHAR2 (500)
)
;
ALTER TABLE "SCOTT"."JORAGUPRA_PEDIDOS"
ADD CONSTRAINT "JORAGUPRA_PEDIDOS_PK1" PRIMARY KEY
(
"ID_PEDIDO"
)
 ENABLE
;
ALTER TABLE "SCOTT"."JORAGUPRA_PEDIDOS"
ADD CONSTRAINT "JORAGUPRA_PEDIDOS_JORAGUP_FK1" FOREIGN KEY
(
"USERNAME"
)
REFERENCES "JORAGUPRA_USUARIOS"
(
"USERNAME"
) ENABLE
;

--Crea la tabla de lineas de pedidos
CREATE TABLE "SCOTT"."JORAGUPRA_LINEAS_PEDIDOS"
(
"NUM_LINEA" NUMBER NOT NULL,
"ID_PEDIDO" NUMBER NOT NULL,
"ID_LIBRO" NUMBER NOT NULL,
"CANTIDAD" NUMBER NOT NULL
)
;
ALTER TABLE "SCOTT"."JORAGUPRA_LINEAS_PEDIDOS"
ADD CONSTRAINT "JORAGUPRA_LINEAS_PEDIDOS_PK1" PRIMARY KEY
(
"NUM_LINEA",
"ID_PEDIDO"
)
 ENABLE
;
ALTER TABLE "SCOTT"."JORAGUPRA_LINEAS_PEDIDOS"
ADD CONSTRAINT "JORAGUPRA_LINEAS_PEDIDOS_FK1" FOREIGN KEY
(
"ID_PEDIDO"
)
REFERENCES "JORAGUPRA_PEDIDOS"
(
"ID_PEDIDO"
) ENABLE
;
ALTER TABLE "SCOTT"."JORAGUPRA_LINEAS_PEDIDOS"
ADD CONSTRAINT "JORAGUPRA_LINEAS_PEDIDOS_FK2" FOREIGN KEY
(
"ID_LIBRO"
)
REFERENCES "JORAGUPRA_LIBROS"
(
"ID_LIBRO"
) ENABLE
;

--Crea la tabla que mantiene el proximo ID para las tablas que lo necesiten
CREATE TABLE "SCOTT"."JORAGUPRA_TABLAS"
(
"TABLA" VARCHAR2 (10) NOT NULL,
"NEXT_ID" NUMBER NOT NULL
)
;
ALTER TABLE "SCOTT"."JORAGUPRA_TABLAS"
ADD CONSTRAINT "JORAGUPRA_TABLAS_PK1" PRIMARY KEY
(
"TABLA"
)
 ENABLE
;