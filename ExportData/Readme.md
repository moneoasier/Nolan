# Nolan

# Helburua
Java proiektu honen helburua menu batetik aukeratzen dira exportatu nahi diren aukerak.
Hau lortzeko, proiektuak 18 java fitxategi ditu:

Hiru paketetan sailkatu ditugu, XML paketea, config paketea eta nolan paketea:

*Config paketea*

1. ExportConfig.java --> Exportatzeko klasea da, hemen Hibernate sartzen da eta Context-a sortzen du.
2. ImportConfig.java --> Importatzeko klasea da, hemen Hibernate sartzen da eta Context-a irakurtzen du.

*Nolan paketea*

3. Datu basetik taula bakoitzeko klase bat sortu da.

*Xml paketea*

4. Menu.java --> Fitxategi nagusia da, hemen datuak idazten ditu eta irakurtzen ditu.
5. Export.java --> log.xml-ko egitura zehaztatzen du. 
6. Exports.java --> log.xml-ko egitura zehaztatzen du.
7. Data.java --> options.xml-ko egitura zehaztatzen du.
8. Option.java --> options.xml-ko egitura zehaztatzen du.

9. Laburtuz, java aplikazioa exekutatzean 2 fitxategi sortuko dira: 
      - options.xml --> aukeratutako eremuak agertuko dira.
      - log.xml --> aukeratutako eremuak noiz exportatu diren.

# Abiaraztea
     cd proiektua dagoen tokira
     mvn spring-boot:run
# Klase diagrama


# Iturriak
https://www.jairogarciarincon.com/clase/interfaces-de-usuario-con-javafx/libretadirecciones-persistencia-de-datos-con-xml <br>
https://www.baeldung.com/jaxb <br>
https://medium.com/el-acordeon-del-programador/leer-un-archivo-xml-con-java-a598a9cdcc44<br>
