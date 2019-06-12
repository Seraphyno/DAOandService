## Login App - Enunt

#### I. Arhitectura dorita:
1. [Layer de database](#database) 
2. [Layer de service](#service) 
3. [Layer de input/form](#form) 

#### II. Tipuri de date si functionalitati:
1. [User](#user)
2. [Database](#db)
3. [Service](#serv)

___________________________________________
___________________________________________

*Note:*
- Cele 3 layere vor sta in _module_ Maven diferite
- In interiorul layerului de database se face si definirea obiectului de tip `User`

#### <a name="database" id="database">1. Layer-ul database</a>
**Cerinte**:
  - Trebuie sa suporte actiuni de tip: _Create_, _Read_, _Delete_ <br>
    
**Pasi necesari**:
  - Creati modulul `database`
  - Creati un package pentru interfete (`api`), in interiorul caruia creati tipurile `IUser` si `IDatabase`
  - Creati un package pt implementari (`impl`), unde veti implementa cele 2 interfete
  - Aditional pentru `Database` va fi nevoie de o metoda statica care sa intoarca o mapa de useri<br>
  Aceasta va fi un `Map<String, IUser>` deoarece vrem sa identificam un user unic dupa un _id_. Acest id poate 
  fi chiar emailul
  - Creati o clasa de test care sa verifice functionalitatea din `Database`

___________________________________________
#### <a name="service" id="service">2. Layer-ul service</a>
**Cerinte**:
  - Trebuie sa preia informatia de la input *UI simulat* (in cazul nostru din `form`) sa o valideze, apoi sa 
  apeleze functionalitatea din database

**Pasi necesari**:
  - Creati modulul `service`
  - Creati un package pentru interfete (`api`), in interiorul caruia creati tipul `IService`. Acesta descrie
   functionalitatea de `login()`, `register()` si `delete()` user
  - Creati un package pt implementari (`impl`), unde veti implementa aceasta interfata<br>
  **Atentie**: pt implementare aveti nevoie sa creati un obiect de tip `Database`
  - Creati o clasa de test care sa verifice functionalitatea din `IService`
___________________________________________
#### <a name="form" id="form">3. Layer-ul form</a>
**Cerinte**:
- Minim suficient sa creati o metoda `main()`

**Pasi necesari**:
  - Creati un modul `application` cu o clasa `Main` care apeleaza aceaste funuctionalitati

___________________________________________
___________________________________________
#### Tipuri de date si functionalitati
___________________________________________
##### <a name="user" id="user">User</a>
Continut:
  - email, parola, name
  - getteri
  
___________________________________________
##### <a name="db" id="db">Database</a>
Continut:
  - o colectie privata care contine useri, proprietate privata
  - `getById(id)`: intoarce userul cu un anumit id, daca exista
  - `getAll()`: intoarce toti userii
  - `save(user)`: salveaza user-ul 
  - `delete(id)`: sterge userul cu id, daca exista

___________________________________________
##### <a name="serv" id="serv">Service</a>
Continut: 
  - contine un obiect de tip `Database` pe care se vor apela operatiile disponibile
  - `login(email, parola)`: verifica in _database_ daca exista user cu acel _id_, il intoarce ca sa verifice 
  _parola_ de pe obiect. In caz de succes saluta userul folosindu-i numele
  - `register(user)`: valideaza input - se verifica inainte de validare daca exista deja un _user_ cu acel 
  _id_. Daca e valid - salveaza in _database_
  - `delete(id)`: daca exista user cu acel _id_, il sterge
