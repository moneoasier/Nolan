# Nolan

# Helburua
Java proiektu honen helburua Odoo zerbitzari batetik datuak irakurtzea eta csv fitxategi batetan gordetzea da. 
Hau lortzeko, proiektuak 5 java fitxategi ditu:
1. ConexionApplication.java --> fitxategi exekutagarria da, hemen AppConfig clasea hartzen da eta barruan dagoen guztua abiarazten da.
2. AppConfig.java --> java Klase honek spring paketeak irakurtzen ditu eta elementu guztiak egiaztatzen ditu.
3. Gafa.java --> Gafa klasea definitzen du, Odoo datu basearen produktu bakoitzaren datuak klase honetako objektu batetan bihurtuko dira.
4. GafaDAO.java --> Intefaze klase bat da, eta crud metodoak ditu barne, klase hau inplementatzen duten elementuek metodo hauek izan beharko dituzte eta erabiliko direnak definitu.
5. GafaTXT.java --> GafaDAO interfazea inplementatzen du eta ekintza hauek exekutako ditu: 
      - Odoo zerbitzariarekin konexioa egin
      - initPreviousList() metodoari deitu --> Dauden datuen fitxategi bat irakurtzen du, elementu bakoitza ArrayList<String> batean gordetzen du.
      - datuak irakurri, datu bakoitza Gafa objektu batean bihurtu, eta ArrayList<Gafa> batean gordetzen du. 
      - erregistroBerria metodoari deitzen dio objektu bakoitzeko id-a pasatuz, eta ArrayList<String>-eko elementuekin konparatzen du dagoeneko hor dagoen jakiteko
      - erregistroBerria false bada, writeTxt() metodoari deitzen dio, honek record.txt-an mezu bat gordetzen du produktu berri bat sortu dela adierazten.
      - Destroy gertatu baino lehen, hau da, objektu hau deuseztatu baino lehen, bi fitxategi sortuko ditu produktuak gordetzeko, bat produktuen datu guztiekin, eta beste bat bakoitzaren id-arekin.

6. Laburtuz, java aplikazioa exekutatzean 3 fitxategi sortuko dira: 
      - gafas.csv --> produktuen datu guztiekin
      - gafasId.csv --> produktuen id-ak
      - record.txt --> gehitu diren produktuen erregistroa


# Klase diagrama
![ExportData](https://user-images.githubusercontent.com/75113996/141777931-7cfebf0d-6a8b-403b-ae58-3e63542eee80.png)


# Iturriak
https://springframework.guru/spring-framework-annotations/ <br>
https://youtu.be/GIyIWpC5YIw <br>
https://youtu.be/qDTUYkaXAEc<br>
http://tutorials.jenkov.com/maven/maven-build-fat-jar.html <br>
https://es.stackoverflow.com/questions/38085/leer-fichero-formato-csv-en-java <br>
https://stackoverflow.com/questions/37487119/operationalerror-could-not-connect-to-server-connection-refused-after-odoo<br>
