TEMA 1 "TRIE" P.O.O -Vijaeac Cristian-Octavian 325CB 

	Pentru rezolvarea cerintelor acestei teme,pe langa interfetele si clasele de test primite in Schelet,am construit un numar de 5 clase:

1)Element1-aceasta clasa implementeaza interfata "TrieElement"
		-contine un camp de tip "String" in care retinem un		cuvant
		- clasa contine un constructor fara parametrii care 		initializeaza variabila de tip String
		-un constructor care primeste ca parametru un String 		si care atribuie variabilei String din clasa noastra 		"valoarea" parametrului primit
		-metoda toCharArray care preia Stringul din clasa si 		intoarce un char[] format din prelucrarea Stringului 		primit ca parametru.Prelucrarea consta in 				transformarea tuturor caracterelor UpperCase in 			LowerCase si crearea vectorului format din literele 		cuvantului prelucrat
		-o metoda toString care va intoarce Stringul din 			clasa

2)Element2-aceasta clasa implementeaza interfata "TrieElement"
		-contine un camp de tip "String" in care retinem un 		cuvant
		- clasa contine un constructor fara parametrii care 		initializeaza variabila de tip String
		-un constructor care primeste ca parametru un String 		si care atribuie variabilei String din clasa noastra 		"valoarea" parametrului primit
		-metoda toCharArray care preia Stringul din clasa si 		intoarce un char[] format din prelucrarea Stringului 		primit ca parametru.Prelucrarea consta in crearea 		unei liste cu elemente de tip "char" si eliminarea 		tuturor caracterelor non-alfanumerice gasite in 			lista cu ajutorul metodei "remove" din clasa 			"ArrayList" si transformarea,dupa prelucrare,a 			listei in vectorul format din literele ramase in 			lista
		-o metoda toString care va intoarce Stringul din 			clasa

3)Node-clasa care creeaza un nod in arborele nostru
	 -nodul va contine un camp "no_Words" de tip intreg ce 	reprezinta numarul de cuvinte existente in acel nod
	 -un camp "children" ce reprezinta un vector de 	referinte(dimensiunea 68 aceeasi cu a alfabetului 	folosit) la alte noduri(initial toate aceste referinte 	sunt null) si in care pozitia unui element reprezinta 	pozitia in alfabet a 	unei litere(de exemplu,daca in 	vector prima referinta nu 	este null,inseamna ca in 	arbore avem un nod asociat 	caracterului "!";modul in care 	am creat alfabetul este evidentiat in clasa "Trie")
	-un camp "element" ce contine o structura de tipul 	TrieElement
	-2 constructori:fara parametrii-initializeaza un nod in 	care 	campurile sunt initializate cu valori	elementare(0,null,etc) cu parametru-primeste un parametru 	de tip TrieElement si initializeaza un nod al carui 	element exista si este definit(contine un cuvant si 	metoda toCharArray)
	-metode de tipul "get" si "set" intrucat toate 	variabilele noastre,cu exceptia vectorului children,sunt 	"private" si avem nevoie de a extrage valori si de a le 	modifica

4)Trie-clasa care implementeaza interfata "AbstractTrie"
	 -clasa care construieste un arbore
	 -contine un camp de tip "Node" si reprezinta radacina 	arborelui
	-clasa contine un singur constructor,fara parametrii care 
	initializeaza un arbore prin construirea radacinii si 	prin 	definirea alfabetului.La fel cum am precizat mai 	sus,am creat un alfabet in care caracterele se afla in 	ordinea codului ascii(primul caracter are codul ascii cel 	mai mic iar ultimul codul ascii cel mai mare).Astfel vom 	putea definii notiunea de "drum" pana la un cuvant 	succesiunea de valori ale literelor transpuse in indici 	ai vectorului de copii conform pozitiei in alfabetul 	creat(daca avem de exemplu "abc" inseamna ca vom avea 	succesiunea 15-16-17 	adica vom accesa elementul cu 	numarul 15 din vectorul de 	copii,dupa aceea elementul cu 	numarul 16 din vectorul de 	copii ai elementului 15 de mai 	sus si dupa aceea elementul 17 al vectorului de 	copii al 	elementului 16)

ADD -primeste ca parametru un element de tip TrieElement si il 	introduce in arbore
	-preia cuvantul din structura si il prelucreaza folosind 	functia toCharArray definita mai sus
	-parcurgem vectorul nou creat,litera cu litera
	-cautam pozitia literei curente in alfabet si returnam 	pozitia
	-daca in vectorul de copii al nodului curent,elementul de 	pe pozitia mai sus intoarsa este null,trebuie sa-l 	initializam si astfel creeam un nod "standard";in caz 	contrar(!=null) ne mutam pe acest element si continuam 	parcurgerea drumului
	-daca am ajuns la sfarsitul cuvantului nostru,adica in 	nodul aferent ultimei litere din cuvant,inseamna ca aici 	trebuie sa facem inserarea
	-daca nodul nostru nu contine un element de tip 	TrieElement,il construim chiar noi,incrementand si nr de 	cuvinte din nod
	-in caz contrar,inseamna ca in nod se afla deja un cuvant 	si incepem sa le comparam.
	-Daca primul cuvant este mai mic d.p.d.v. lexicografic 	decat primul,il inseram in nod inlocuind cuvantul deja 	existent
	-altfel,nu il inseram
	-in ultimele 2 cazuri vom incrementa numarul de cuvinte 	din 	nod.

REMOVE-primeste ca parametriu un element de tip TrieElement si 	il sterge din arbore
	-preia cuvantul din structura si il prelucreaza folosind 	functia toCharArray definita mai sus
	-parcurgem vectorul nou creat,litera cu litera
	-cautam pozitia literei curente in alfabet si returnam 	pozitia
	-daca in vectorul de copii al nodului curent,elementul de 	pe pozitia mai sus intoarsa este null,inseamna ca nu 	exista cuvantul nostru in arbore si astfel stergerea 	fiind imposibila.In acest caz iesim din functie
	-daca exista elementul,ne mutam pe el si continuam 	
	parcurgerea drumului
	-cand ajungem la sfarsitul cuvantului,adica in ultimul 	nod,inseamna ca aici se afla elementul care trebuie sters
	-daca numarul de cuvinte din nod este >1 trebuie doar sa 	stergem o aparitie a cuvantului,adica sa decrementam 	contorul care memoreaza numarul de cuvinte din nod
	-daca numarul de cuvinte este chiar 1,trebuie sa stergem 	cuvantul din arbore si astfel facem structura TrieElement 	care contina cuvantul sa fie null si nr de cuvinte devine 	0
	-daca nu se intra pe niciunul din cazuri inseamna ca nu 	exista deloc cuvinte in acel nod si astfel iesim din 	functie

COUNT-primeste ca parametriu un element de tip TrieElement si 	returneaza numarul de aparitii ale cuvantului in arbore
	-preia cuvantul din structura si il prelucreaza folosind 	functia toCharArray definita mai sus
	-parcurgem vectorul nou creat,litera cu litera
	-cautam pozitia literei curente in alfabet si returnam 	pozitia
	-daca in vectorul de copii al nodului curent,elementul de 	pe pozitia mai sus intoarsa este null,inseamna ca nu 	exista cuvantul nostru in arbore si astfel intoarcem 0
	-daca exista elementul,ne mutam pe el si continuam 	
	parcurgerea drumului
	-cand ajungem la sfarsitul cuvantului,adica in ultimul 	nod,inseamna ca aici se afla elementul cautat si astfel 	intoarcem numarul de cuvinte memorat in acest nod

getSortedElements-primeste ca parametrii un element de tip 	TrieElement si 	returneaza un vector de structuri 	TrieElement care contine toate cuvintele formate cu 	ajutorul prefixului trimis ca parametru
	-preia prefixul din structura si il prelucreaza folosind 	functia toCharArray definita mai sus
	-parcurgem vectorul nou creat,litera cu litera
	-cautam pozitia literei curente in alfabet si returnam 	pozitia
	-daca in vectorul de copii al nodului curent,elementul de 	pe pozitia mai sus intoarsa este null,inseamna ca nu 	exista cuvantul nostru in arbore si astfel tragem 	concluzia ca nu 	exista cuvinte care incep cu acel 	prefix,intorcand null
	-daca exista elementul,ne mutam pe el si continuam 	
	parcurgerea drumului
	-la finalul parcurgerii ne aflam pe nodul de unde trebuie 	sa incepem afisarea
	-folosim functia recursiva SDR

	SDR-primeste ca parametrii o lista de tipul ArrayList 	formata din structuri TrieElement(am ales sa folosesc 	acest	tip de date deoarece nu trebuie alocat spatiu in 	prealabil,programul nestiind cate cuvinte urmeaza sa 	scrie	in aceasta lista si totodata datorita metodei add 	care 	adauga elementele la sfarsitul listei) si nodul de 	unde 	porneste cautare
	-daca in nodul in care ne aflam contorul care memoreaza 	cate 	cuvinte se afla in nod este >=1 inseamna ca exista 	cuvinte si astfel introducem in lista cuvantul gasit
	-pentru nodul curent,apelam recursiv functia pentru 	fiecare copil existent al nodului si dupa aia pt fiecare 	copil al copiilor nodului curent si tot asa,acesti copii 	devenind noduri curente
	-astfel vom parcurge tot arborele si vom memora toate 	cuvintele gasite(parcurgerea se face STANGA DREAPTA 	RADACINA pentru pastrarea ordinii)

	-la sfarsitul rularii functiei recursive,folosindu-ne de 	functia toCharAray existenta in clasa ArrayList,returnam 	un vector de TrieElement format din toate elementele 	listei si avand aceeasi dimensiune cu lista.

5)Test-functie care contine main-ul
	-folosindu-ne de pachetul test primit in 	prealabil,accesam metodele si clasele pentru deschiderea 	unui fisier pentru citire si unul pentru scriere,citirea	cuvintelor care se insereaza initial in arbori,a 	comenzilor,a cuvintelor si a prefixelor din fisier
	-construim cei 2 arbori care contin elemente de tip 	Element1 respectiv Element2 cu ajutorul cuvintelor aflate 	pe prima linie din fisier
	-parcurgem vectorii de comenzi pentru primul 	caz,respectiv al doilea, si,in functie de indicele pe 	care il citim din fisier,alegem functia pe care sa o 	executam(0-add 1-remove 2-count 3- getSortedElements)
	-pentru functiile count si getSortedElement apelam 	functiile 	de scriere in fisier construite in interiorul 	clasei TestWriter si afisam ceea ce returneaza aceste 	functii