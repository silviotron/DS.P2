import e1.*;
import e3.Bicola;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    /*
    Bicola<String> bicola = new Bicola<>();
    bicola.insertarDch("hola");
    bicola.insertarDch("que");
    bicola.insertarDch("tal");
    bicola.insertarIzq("izquierda");
    System.out.println(bicola.toString());
    for (String s : bicola){
        System.out.println(s);
    }
    */

    Juego juego = new Juego();
    juego.addAzul(new Elfo("PEPE",100,100));
    juego.addAzul(new Orco("LUIS",100,100));
    juego.addAzul(new Humano("MARCOS",100,100));
    juego.addAzul(new Elfo("JUNINHO",100,100));
    juego.addAzul(new Elfo("SELTON",100,100));
    juego.addAzul(new Elfo("ARITZ",100,100));

    juego.addRojo(new Elfo("OSCAR",100,100));
    juego.addRojo(new Humano("CHARLES",100,100));
    juego.addRojo(new Elfo("AYMERIC",100,100));
    juego.addRojo(new Elfo("MAROAN",100,100));
    juego.addRojo(new Elfo("WIWI",100,100));
    juego.addRojo(new Trasgo("EMAD",100,100));

    for (String s : juego.batalla()){
        System.out.println(s);
    }



   /* ListaCanciones playlist = new ListaCanciones();
    playlist.add(new Cancion("Come as you are","Nirvana","Nirvana","Grunge"));
    playlist.add(new Cancion("Como Camaron","Nirvana","Estopa","Rumba"));
    playlist.add(new Cancion("Lithium","Nirvana","Nirvana","Grunge"));
    playlist.add(new Cancion("Por la raja de tu falda","Nirvana","Estopa","Rumba"));
    IO.println(playlist);

    playlist.move(1,2);
    IO.println(playlist);

    playlist.remove(0);
    IO.println(playlist);

    IO.println(playlist);
    playlist.next();
    IO.println(playlist);
    playlist.next();
    IO.println(playlist);

    playlist.remove(0);
    IO.println(playlist);
*/
    //IO.println(playlist.get(0));
    //IO.println(playlist.get(1));
    //IO.println(playlist.get(2));
    //IO.println(playlist.get(3));




}
