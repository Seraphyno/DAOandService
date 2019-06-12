se doreste implementarea unei aplicatii care are ca scop functionalitatea de login si de register pe o platforma web

Arhitectura dorita:
1. Layer de database - trebuie sa suporte Create, Read, Delete
2. Layer de service - trebuie sa preia informatia de la input *UI simulat* sa valideze, apoi sa acceseze functionalitatea de database
3. Layer de intrare/input - e suficient sa creati o metoda main

Note:
- cele 3 layere vor sta in module maven diferite
- in interiorul layerului de database se face si definirea obiectului de tip User

Pasul 1:
Creati modulul database
Creati un package pentru interfete, in interiorul caruia creati tipul User si Database
Creati un package pt implementari, unde veti implementa cele 2 interfete
Aditional pentru Database va fi nevoie de o metoda statica care sa intoarca o mapa/lista de useri
Creati o clasa de test care sa verifice functionalitatea din Database

Pasul 2:
Creati modulul service (form) 
Creati un package pentru interfete, in interiorul caruia creati tipul Service. Acesta descrie functionalitatea de login, register si delete user
Creati un package pt implementari, unde veti implementa aceasta interfata
Atentie: pt implementare aveti nevoie sa creati un obiect de tip database
Creati o clasa de test care sa verifice functionalitatea din Service

Optional:
Creati un modul de application cu o clasa main care apeleaza aceasta funuctionalitate

Tipuri si functionalitati:
- User
	- email, parola, name
	- getteri
- Database
	- o colectie privata care contine useri, proprietate privata
	- getById(id): intoarce userul cu un anumit id, daca exista
	- getall(): intoarce toti userii
	- save(user): salveaza user-ul 
	- delete(id): sterge userul cu id, daca exista
- Service
	- contine un obiect de tip database pe care se vor apela operatiile disponibile
	- login(email, parola): verifica in db daca exista user cu acel id, il intoarce ca sa verifice parola de pe el. in caz de succes saluta userul folosindu-i numele
	- register(user): valideaza input - optional se poate verifica inainte de validare daca exista deja un user cu acel id. daca e valid - salveaza in database
	- delete(id): daca exista userul, il sterge