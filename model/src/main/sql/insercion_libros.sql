--Inserta datos en la tabla de libros
--El orden de los campos de la tabla es: (ID_LIBRO, TITULO, ID_AUTOR, ID_EDITORIAL, ID_CATEGORIA, ISBN, ENCUADERNACION, PAGINAS, IDIOMA, RESUMEN) 
INSERT INTO JORAGUPRA_LIBROS VALUES (1, 'Desarrollo Web con PHP y MySQL', 1, 
                                     'ANMUL', 'INFOR', '8441518181', 
                                     'Rústica', 974, 'Español', 51.00, 
                                     NULL);
INSERT INTO JORAGUPRA_LIBROS VALUES (2, 'Desarrollo Web con PHP y MySQL. Programación', 
                                     1, 'ANMUL', 'INFOR', '8441515697', 
                                     'Rústica', 912, 'Español', 50.00, 
                                     'PHP y MySQL son conocidas tecnologías de código abierto que resultan muy útiles para diseñar de forma rápida y eficaz aplicaciones Web dirigidas a bases de datos. 
                                     PHP es un potente lenguaje de secuencia de comandos diseñado específicamente para permitir a los programadores crear aplicaciones Web con distintas prestaciones de forma rápida. MySQL es una base de datos rápida y fiable que se integra a la perfección con PHP y que resulta muy adecuada para aplicaciones dinámicas basadas en Internet.
                                     En este libro veremos cómo utilizar estas herramientas de forma conjunta para obtener aplicaciones Web eficaces e interactivas, desde los formularios de pedidos más sencillos hasta los sitios de comercio electrónico más complejos y seguros. Se describen los fundamentos del lenguaje PHP, se explica cómo configurar y trabajar con una base de datos MySQL, y aprenderá a utilizar PHP para interactuar con la base de datos y el servidor.
                                     Este manual tan práctico y sencillo incluye numerosos ejemplos de tareas habituales como la autenticación de usuarios, la construcción de un carro de la compra, la generación dinámica de documentos PDF e imágenes, el envío y gestión de correo electrónico, la comunicación entre usuarios, la administración de contenidos y la conexión a servicios Web por medio de XML. 
                                     Se abordan aspectos relacionados con el comercio electrónico y la seguridad mientras desarrollamos un sitio Web real y le mostraremos cómo implementarlos en PHP y MySQL.
                                     Incluye CD-ROM con las versiones completas de PHP, MySQL, Apache, varias bibliotecas gráficas, y los archivos que contienen los listados de código del libro.');

INSERT INTO JORAGUPRA_LIBROS VALUES (3, 'Desarrollo Web con JSP', 
                                     2, 'ANMUL', 'INFOR', '844151352X', 
                                     'Rústica', 848, 'Español', 47.00, 
                                     'Las páginas de servidor Java (JSP) representan una tecnología cada vez más popular para construir aplicaciones web dinámicas que pueden acceder a bases de datos y proporcionar una experiencia interactiva a los usuarios de su sitio web.');

INSERT INTO JORAGUPRA_LIBROS VALUES (4, 'Crystal Report: The complete reference', 
                                     3, 'MCGRA', 'INFOR', '0072231661', 
                                     'Rústica', 928, 'Español', 45.00, 
                                     'Create visually appealing reports and publish them on the Web with Crystal Reports 10 and help from this comprehensive resource.
                                     Whether you´re a beginner or a power user looking for answers to quick questions, many examples and tips, along with clear discussions of the neww and improved features, make this a must-have workplace companion.');

INSERT INTO JORAGUPRA_LIBROS VALUES (5, 'Introducción a los sistemas de bases de datos (7ª Ed.)', 
                                     4, 'ALHAM', 'INFOR', '9684444192', 
                                     'Rústica', 936, 'Español', 38.90, 
                                     NULL);

INSERT INTO JORAGUPRA_LIBROS VALUES (6, 'Patrones de diseño: elementos de software orientado a objetos reutilizables', 
                                     5, 'ADDIB', 'INFOR', '8478290591', 
                                     'Rústica', 348, 'Español', 26.90, 
                                     'Es un libro de patrones de diseño que describen soluciones simples y elegantes para problemas específicos del diseño de software orientado a objetos.');

INSERT INTO JORAGUPRA_LIBROS VALUES (7, 'Patrones de diseño aplicados a Java', 
                                     6, 'PEAED', 'INFOR', '8420538396', 
                                     'Rústica', 616, 'Español', 35.90, 
                                     'Cada vez más, los desarrolladores están reconociendo el valor de los patrones de diseño como un ayuda para crear aplicaciones más robustas, escalables, fiables y fáciles de mantener. Los expertos  de Sun Microsystems Stephen Stelting y Olav Maassen explican las mejores técnicas basadas en patrones actuales y muestran la utilización de los patrones de diseño en una amplia gama de sistemas empresariales.');

INSERT INTO JORAGUPRA_LIBROS VALUES (8, 'UML y patrones: Introducción al análisis y diseño orientado a objetos', 
                                     7, 'PRENH', 'INFOR', '9701702611', 
                                     'Rústica', 356, 'Español', 32.90, 
                                     NULL);

INSERT INTO JORAGUPRA_LIBROS VALUES (9, 'Conferencias sobre computación', 
                                     8, 'CRITI', 'INFOR', '8484324443', 
                                     'Cartoné', 320, 'Español', 24.00, 
                                     'Richard Feynman (1918-1988) fue uno de los científicos más creativos y originales del siglo XX. Honrado por la Academia Sueca en 1965 con el Premio Nobel de Física por sus tan profundas como idiosincrásicas contribuciones al desarrollo de la electrodinámica cuántica, Feynman se caracterizó como científico por la claridad y originalidad de sus enfoques, así como por la variedad de sus intereses, 
                                     desde la física cuántica y de altas energías hasta la física estadística, pasando por la gravitación o la física general. Asimismo, y aunque es menos conocido, se interesó por la teoría de la computación, a la que dedicó cursos hoy legendarios en el California Institute Of Technology. El presente libro recupera los contenidos de aquellos cursos, que con justicia pueden considerarse todo un clásico de la ciencia contemporánea.');

INSERT INTO JORAGUPRA_LIBROS VALUES (10, 'Construcción de software orientado a objetos', 
                                     9, 'PRENH', 'INFOR', '8483220407', 
                                     'Rústica', 1247, 'Español', 69.90, 
                                     NULL);

INSERT INTO JORAGUPRA_LIBROS VALUES (11, 'Un matemático invierte en la bolsa', 
                                     10, 'TUSQE', 'ECON', '8483109700', 
                                     'Rústica', 257, 'Español', 16.00, 
                                     'John Allen Paulos sintió a finales de los años noventa, en pleno auge de las empresas «punto com», la irresistible atracción del mundo de la Bolsa. Invirtió dinero, especuló con acciones, se arriesgó cada vez más y... ¡perdió!, tal vez al igual que muchos de sus lectores. En este libro, repleto de inolvidables y divertidísimas anécdotas, pero también de iluminadoras explicaciones sobre el cálculo de probabilidades, 
                                     la estadística aplicada o las variadísimas fomas en que nuestro dinero puede multiplicarse... y también esfumarse, Paulos desentraña para todos nosotros una serie de interrogantes: ¿trabajan los mercados de forma predecible o están gobernados por el más desesperante azar?, ¿cómo se puede cuantificar el riesgo de una inversión?, ¿son eficaces los análisis técnicos a la hora de escoger las acciones?, ¿cuáles son las estafas más habituales?.');

INSERT INTO JORAGUPRA_LIBROS VALUES (12, 'Manual del buen bolsista: Todo lo que necesita saber para actuar en bolsa como un verdadero profesional', 
                                     11, 'PEAED', 'ECON', '842053451X', 
                                     'Cartoné', 368, 'Español', 18.90, 
                                     'Conocer la bolsa e invertir con éxito no es complicado si se va de la mano de quien, como Hódar, ha recorrido el largo camino que va desde operador, inversor, gestor de patrimonios, profesor, conferenciante y analista del diario económico Expansión y de Expansión TV. 
                                     Con este manual no se hará millonario inviertiendo en bolsa. Pero si sigue sus enseñanzas jamás tendrá un serio descalabro. 
                                     Sacará una atractiva rentabilidad a sus ahorros y logrará que invertir sea una actividad divertida, e incluso puede que consiga disfrutar más acertando en sus pronósticos, que ganando dinero.');

INSERT INTO JORAGUPRA_LIBROS VALUES (13, 'Principios de finanzas corporativas', 
                                     12, 'MCGRA', 'ECON', '8448121562', 
                                     'Cartoné', 962, 'Español', 53.96, 
                                     'Este libro expone la teoría y la práctica de la dirección financiera en la empresa. No es necesario explicar por qué los directivos financieros deberían ser maestros en la vertiente práctica de su trabajo, pero pueden resultar útiles unas palabras sobre el papel de la teoría. Los directivos aprenden con la experiencia cómo hacer frente a los problemas cotidianos. 
                                     Pero los mejores directivos también son capaces de responder a los cambios. Para hacer esto, usted necesita algo más que unas reglas prácticas consagradas para discurrir del tiempo; tiene que comprender por qué las empresas y directivos financieros actúan de la forma en que lo hacen. En otras palabras, necesita una teoría financiera de la empresa.');

INSERT INTO JORAGUPRA_LIBROS VALUES (14, 'Fundamentos de finanzas corporativas', 
                                     12, 'MCGRA', 'ECON', '8448141954', 
                                     'Rústica', 610, 'Español', 49.95, 
                                     NULL);

INSERT INTO JORAGUPRA_LIBROS VALUES (15, 'De cara al mar: Ayer y hoy del litoral de Barcelona', 
                                     13, 'LUNWE', 'ARQ', '8497850106', 
                                     'Cartoné', 462, 'Español', 49.50, 
                                     NULL);

INSERT INTO JORAGUPRA_LIBROS VALUES (16, 'Tratados de urbanismo y sociedad', 
                                     14, 'CLAN', 'ARQ', '8489142742', 
                                     'Rústica', 185, 'Español', 11.50, 
                                     NULL);

INSERT INTO JORAGUPRA_LIBROS VALUES (17, 'La ciudad de las columnas', 
                                     15, 'ESPCA', 'ARQ', '846701606X', 
                                     'Cartoné', 176, 'Español', 19.90, 
                                     'El excepcional escritor cubano Alejo Carpentier, premio Cervantes en 1977, escribió este pequeño ensayo como un sincero y emocionado homenaje a su ciudad natal, la Habana que desde que se publicó este ensayo es conocida precisamente como "la ciudad de las columnas". 
                                     La mezcla de estilos arquitectónicos, producto de su mestizaje, es quizá una de sus principales características. 
                                     El recorrido arquitectónico del escritor se complementa con 75 fotografías que nos permiten comprobar la original belleza de una de las ciudades más impactantes del Nuevo Continente.');

INSERT INTO JORAGUPRA_LIBROS VALUES (18, 'El lado oscuro del hombre: los orígenes de la violencia masculina', 
                                     16, 'TUSQE', 'BIOLOG', '8483104016', 
                                     'Rústica', 375, 'Español', 20.00, 
                                     '¿Cuáles son las raíces biológicas de la violencia humana? ¿Tienen la guerra o el asesinato algún papel adaptativo en la evolución humana? ¿Por qué suelen ser más violentos los hombres que las mujeres? 
                                     En este sorprendente y sin duda polémico ensayo, Michael Ghiglieri propone un persuasivo enfoque biológico del comportamiento humano y reorienta el viejo debate sobre el predominio de los instintos naturales o la educación, de la genética o el entorno, y de la cultura o la biología.
                                     Basándose, sobre todo, en el estudio comparativo de la conducta de los grandes simio, además de en las más variadas fuentes, desde las aportaciones científicas hasta innumerables entrevistas personales, ghiglieri nos brinda un actualizado y ambicioso análisis de los orígenes de la violencia y la agresividad en nuestras sociedades. 
                                     Desde disciplinas tan variadas como la biología, la psicología, la antropología, la historia y la sociología, el lado oscuro del hombre aborda aspectos del comportamiento humano –la violación, la criminalidad o las guerras– que parecen enraizados en lo más profundo de nuestros instintos. Comenzar a reconocerlo y a aceptarlo, argumenta ghiglieri, puede ser el primer paso para hallarles una solución.');

INSERT INTO JORAGUPRA_LIBROS VALUES (19, 'Introducción a la criminología (2a Ed.)', 
                                     17, 'DYKIN', 'DER', '8497725069', 
                                     'Rústica', 523, 'Español', 40.00, 
                                     NULL);

INSERT INTO JORAGUPRA_LIBROS VALUES (20, 'Historia del derecho romano: Política, doctrinas, legislación y administración', 
                                     18, 'DYKIN', 'DER', '8497724275', 
                                     'Rústica', 525, 'Español', 20.00, 
                                     NULL);





