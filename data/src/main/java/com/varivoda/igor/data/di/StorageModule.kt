package com.varivoda.igor.data.di

import android.preference.PreferenceManager
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.varivoda.igor.data.Preferences
import com.varivoda.igor.data.database.AppDatabase
import com.varivoda.igor.data.repository.RiddleRepositoryImpl
import com.varivoda.igor.domain.repository.RiddleRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val storageModule = module {

    single { Room.databaseBuilder(androidContext(), AppDatabase::class.java,"zagonetke.db")
            .fallbackToDestructiveMigration().addCallback(object: RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                db.execSQL("INSERT INTO Points VALUES(1,42,0)")
                db.execSQL("insert into Riddle values(0,'Svakog dana stotine nogu pregazi moja rebra, a ja i dalje stojim, jer ja sam ...','ZEBRA',0)")
                db.execSQL("insert into Riddle values(1,'Velik sam kao kuća, a malenog se miša bojim. Nos mi je do poda, čak i kada stojim.','SLON',0)")
                db.execSQL("INSERT INTO Riddle values(2,'Maleni sam, nisam velik, ni previše snažan, ali svoju kuću nosim i pravim se važan.','PUŽ',0)")
                db.execSQL("INSERT INTO Riddle values(3,'Svaki dan je puniš, a nikad nije puna!','GLAVA',0)")
                db.execSQL("INSERT INTO Riddle values(4,'Kao najlakša ptica letim, a težak sam kao slon, pijem samo benzin i zovem se ...','AVION',0)")
                db.execSQL("INSERT INTO Riddle values(5,'Ako je imaš, želiš je dijeliti. Ako je podijeliš, više je nemaš. Što je to?','TAJNA',0)")
                db.execSQL("INSERT INTO Riddle values(6,'Imam oka tri, al ni jedno ne vidi.Ali moje oči mnogo znače za pješake i vozače.','SEMAFOR',0)")
                db.execSQL("INSERT INTO Riddle values(7,'Ima brke, djed nije. Mlijeko pije, dijete nije.','MAČAK',0)")
                db.execSQL("INSERT INTO Riddle values(8,'Kako s tri slova opisati krutu vodu?','LED',0)")
                db.execSQL("INSERT INTO Riddle values(9,'Kad ga nema fali ti, kad ga mnogo ima dosadi ti!','LJETO',0)")
                db.execSQL("INSERT INTO Riddle values(10,'Imam igle ne znam šiti, tko će mene pogoditi?','JEŽ',0)")
                db.execSQL("INSERT INTO Riddle values(11,'Svi što ju vole svi ju tuku udaraju nogom i bacaju iz ruku.','LOPTA',0)")
                db.execSQL("INSERT INTO Riddle values(12,'Što ga više ima, to ga manje vidiš. Što je to?','MRAK',0)")
                db.execSQL("INSERT INTO Riddle values(13,'Kad ga trebaš, baciš ga, kad ga ne trebaš izvadiš ga.','SIDRO',0)")
                db.execSQL("INSERT INTO Riddle values(14,'Pliva u vodi, po kopnu hodi, a iz kuće ne izlazi.','KORNJAČA',0)")
                db.execSQL("INSERT INTO Riddle values(15,'Puna sam rupa, a ipak držim vodu.','SPUŽVA',0)")
                db.execSQL("INSERT INTO Riddle values(16,'Lakši je od pera, ali ni najjači čovjek ne može ga držati dulje od 3 minute.','DAH',0)")
                db.execSQL("INSERT INTO Riddle values(17,'Danju svakog vjerno prati, a noću je nikad nema.','SJENA',0)")
                db.execSQL("INSERT INTO Riddle values(18,'Leti a nema krila, plače a nema očiju.','OBLAK',0)")
                db.execSQL("INSERT INTO Riddle values(19,'Ja sam majčino dijete i očevo dijete, ali nisam ničiji sin. Tko sam ja?','KĆI',0)")
                db.execSQL("INSERT INTO Riddle values(20,'Što leti kad se rodi, leži kad je živo i teče kad umre?','PAHULJICA',0)")
                db.execSQL("INSERT INTO Riddle values(21,'Imam glavu, nemam tijelo, imam naličje. Što sam ja?','KOVANICA',0)")
                db.execSQL("INSERT INTO Riddle values(22,'Žuto blago u bijeloj kući, ni prozora ni vrata, nitko ne može ući.','ŽUMANJAK',0)")
                db.execSQL("INSERT INTO Riddle values(23,'Bacamo mu listove, a jedemo sjeme. Što je to?','KUKURUZ',0)")
                db.execSQL("INSERT INTO Riddle values(24,'Što je visoko kad je mlado, a nisko kad je staro?','SVIJEĆA',0)")
                db.execSQL("INSERT INTO Riddle values(25,'Potreban sam ljudima,ali me svakodnevno troše.Što sam ja?','NOVAC',1)")
                db.execSQL("INSERT INTO Riddle values(26,'Nema noge,brzo bježi, od nje svaki stvor se ježi?','ZMIJA',1)")
                db.execSQL("INSERT INTO Riddle values(27,'Bez obzira kolika je, nema težine. Ali stavi je u bačvu i osvjetlit će je iznutra.','RUPA',1)")
                db.execSQL("INSERT INTO Riddle values(28,'Ide ravno, pa zavije. Po njoj auti jure, po njoj ljudi žure.','CESTA',1)")
                db.execSQL("INSERT INTO Riddle values(29,'Tvoje je, ali ga svi koriste puno više od tebe. Što je to?','IME',1)")
                db.execSQL("INSERT INTO Riddle values(30,'Cijeli dan ide, a ne pomakne se.','SAT',1)")
                db.execSQL("INSERT INTO Riddle values(31,'U njoj se ogledaš, ogledalo nije.','VODA',1)")
                db.execSQL("INSERT INTO Riddle values(32,'O klinu visi, o zlu misli.','PUŠKA',1)")
                db.execSQL("INSERT INTO Riddle values(33,'Jedna glava, a stotinu kapa.','KUPUS',1)")
                db.execSQL("INSERT INTO Riddle values(34,'Korice ima - nož nije, listove ima drvo nije.','KNJIGA',1)")
                db.execSQL("INSERT INTO Riddle values(35,'Koji izum omogućava da gledate kroz zid?','PROZOR',1)")
                db.execSQL("INSERT INTO Riddle values(36,'Uvijek ispred tebe, a ne možeš je vidjeti?','BUDUĆNOST',1)")
                db.execSQL("INSERT INTO Riddle values(37,'Nestanem čim mi izgovorite ime. Što sam ja?','TIŠINA',1)")
                db.execSQL("INSERT INTO Riddle values(38,'Ima mnogo zuba, ali ništa ne jede. Što je to?','ČEŠALJ',1)")
                db.execSQL("INSERT INTO Riddle values(39,'Što počinje i nema kraja, ali je kraj svemu što počinje?','SMRT',1)")
                db.execSQL("INSERT INTO Riddle values(40,'Zijeva, a jezika ne ima.','ŠKARE',1)")
                db.execSQL("INSERT INTO Riddle values(41,'Ima korijenje koje niko ne vidi, više je od najvišeg drveta, a nikad ne raste…','PLANINA',1)")
                db.execSQL("INSERT INTO Riddle values(42,'Možeš me baciti sa najviše zgrade i bit ću dobro, ali ako me baciš u vodu umrijet ću. Što sam ja?','PAPIR',1)")
                db.execSQL("INSERT INTO Riddle values(43,'Možeš me naći u vodi, ali nikada smočenog. Što sam ja ?','ODRAZ',1)")
                db.execSQL("INSERT INTO Riddle values(44,'Ko prvi u kuću uđe?','KLJUČ',1)")
                db.execSQL("INSERT INTO Riddle values(45,'U početku ide na četiri noge, onda na dvije, a na kraju na tri.','ČOVJEK',1)")
                db.execSQL("INSERT INTO Riddle values(46,'Ne vidiš me al sam jak, lako dižem sve u zrak.','VJETAR',1)")
                db.execSQL("INSERT INTO Riddle values(47,'Ne jedeš ga, ne piješ ga, a živiš od njega.','ZRAK',1)")
                db.execSQL("INSERT INTO Riddle values(48,'Danju laže, a noću je istina.','SAN',1)")
                db.execSQL("INSERT INTO Riddle values(49,'Zimi putuju, ljeti odmaraju.','SANJKE',1)")
                db.execSQL("INSERT INTO Riddle values(50,'Bez ijednog čavla, a visi na zidu?','PAUČINA',1)")
                db.execSQL("INSERT INTO Riddle values(51,'Koga udaraju najviše po glavi?','ČAVAO',1)")
                db.execSQL("INSERT INTO Riddle values(52,'Šta je najbrže na svijetu?','MISAO',1)")
                db.execSQL("INSERT INTO Riddle values(53,'Čvrsta kuća i nema nijedna vrata, u njoj žive četiri brata.','ORAH',1)")
                db.execSQL("INSERT INTO Riddle values(54,'Bez očiju, bez ušiju, a slijepce vodi.','ŠTAP',1)")
                db.execSQL("INSERT INTO Riddle values(55,'Padne u vodu, a ne pokvasi se.','SJENA',1)")
                db.execSQL("INSERT INTO Riddle values(56,'Ima sve prste, a nijednog nokta!','RUKAVICE',1)")
                db.execSQL("INSERT INTO Riddle values(57,'Nit stoji u sobi nit stoji vani.','PROZOR',1)")
                db.execSQL("INSERT INTO Riddle values(58,'Puna škola đaka, nigdje nema vrata.','LUBENICA',1)")
                db.execSQL("INSERT INTO Riddle values(59,'Nema ni jezik, a ni usta, a može da govori.','OLOVKA',1)")
                db.execSQL("INSERT INTO Riddle values(60,'Što više vučeš, to se više skraćuje. Što je to?','CIGARETA',2)")
                db.execSQL("INSERT INTO Riddle values(61,'Brada mu viri iz kuće, a on u kući!','KUKURUZ',2)")
                db.execSQL("INSERT INTO Riddle values(62,'Dok me hraniš, živjet ću. Kad mi daš piti, umrijet ću. Što sam ja?','VATRA',2)")
                db.execSQL("INSERT INTO Riddle values(63,'Što je crno kad ga kupite, crveno dok ga koristite, a sivo kad ga bacate?','UGLJEN',2)")
                db.execSQL("INSERT INTO Riddle values(64,'Ljudi me kupuju da bi jeli, ali me nikad ne pojedu. Što sam ja?','BEŠTEK',2)")
                db.execSQL("INSERT INTO Riddle values(65,'Onaj tko ga napravi, njemu ne treba. Onaj tko ga kupi, nema koristi od njega. Što je to?','LIJES',2)")
                db.execSQL("INSERT INTO Riddle values(66,'Nastao sam iz vode, ali ako me vratite u vodu, nestat ću. Što sam ja?','LED',2)")
                db.execSQL("INSERT INTO Riddle values(67,'Noge u blatu, a glava u zlati!','SVIJEĆA',2)")
                db.execSQL("INSERT INTO Riddle values(68,'Nema ni oca, ni mater, a rađa se svaki novi dan.','ZORA',2)")
                db.execSQL("INSERT INTO Riddle values(69,'Što je više oduzimaš to postaje veća.','RUPA',2)")
                db.execSQL("INSERT INTO Riddle values(70,'Čuo si me jednom,a zatim još jednom.Nestanem dok me ne pozoveš ponovno.Što sam ja?','ODJEK',2)")
                db.execSQL("INSERT INTO Riddle values(71,'U vodi je suho, a u vatri mokro?','OLOVO',2)")
                db.execSQL("INSERT INTO Riddle values(72,'Sve može u kuću, a rogovi ne mogu?','SVRDLO',2)")
                db.execSQL("INSERT INTO Riddle values(73,'Kada je auto u zavoju, koji se kotač manje okreće?','REZERVNI',2)")
                db.execSQL("INSERT INTO Riddle values(74,'Mogu biti od pijeska, Sunca ili metala. Tko sam ja?','SAT',2)")
                db.execSQL("INSERT INTO Riddle values(75,'Mogu čuti, vidjeti, mirisati, osjetiti i još puno toga, a nemam ni jezika, ni oči, ni uši...','MOZAK',2)")

            }})
        .build()
    }

    single { RiddleRepositoryImpl(get()) as RiddleRepository }

    single (override = true) { PreferenceManager.getDefaultSharedPreferences(get()) }

    single { Preferences(get()) }
}