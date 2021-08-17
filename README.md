# _igym.hu_ fejlesztői weboldalának automata tesztelése
A tesztelt oldal az alábbi linken https://igym-igym-dev.azurewebsites.net/ érhető el.
Az automata tesztek elkészítéséhez használt manuális teszteseteket tartalmazó dokumentum megtalálható a repóban is vizsgaremek(igym).xls fájlban, de az adott linken is elérhető https://drive.google.com/file/d/1kmF9x_X54k_y8FjWzh6vaFjlVx4uyyJu/view?usp=sharing .

Az oldalra elkészített automata tesztek az alábbi funkciókat teszteli le!

**Az oldal funkcionális tesztelése:**
- 
* **_Regisztráció:_** pozitív és negatív tesztesetekkel (pl: érvénytelen jelszó, nem egyező jelszavak megadásával)
* **_Bejelentkezés:_** pozitív és negatív tesztesetekkel (pl: bejelentkezés email cím nélkül, érvénytelen jelszó,... )
* **_Adatkezelési nyilatkozat használata:_** nyilatkoztat megnyitása, ablakváltás, majd nyilatkozat bezárása
* **_Adatok listázása:_** a honlapon található edzések listázása edzéstípus alapján (pl.: "Jóga")
* **_Többoldalas lista bejárása:_** a naptárban végigjárni az összes edzést, megszámolni az összeset, és kategóriák szerint is külön, majd összehasonlítani, hogy megegyeznek
* **_Új adat bevitel:_** regisztrált felhasználó nevének, becenevének bevitele
* **_Ismételt és sorozatos adatbevitel:_** regisztrált felhasználó számlázási adatainak bevitele, majd módosítása
* **_Adat vagy adatok törlése:_** felhasználó számlázási címének törlése
* **_Adatok lementése felületről:_** adott napon lévő edzések kilistázása és lementése a trainingResult.txt fájlba
* **_Kijelentkezés:_**

A tesztelés eredményéről automatikusan generált jelentés a https://zotyo911.github.io/vizsgaremek_2.0/ linken tekinthető meg.



