import e2.Cancion;
import e2.ListaCanciones;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    ListaCanciones playlist = new ListaCanciones();
    IO.println(playlist);
    playlist.add(new Cancion("Come as you are","Nirvana","Grunge"));
    playlist.add(new Cancion("Como Camaron","Estopa","Rumba"));
    playlist.add(new Cancion("Lithium","Nirvana","Grunge"));
    playlist.add(new Cancion("Por la raja de tu falda","Estopa","Rumba"));

    IO.println(playlist);

    playlist.next();
    playlist.next();
    playlist.next();
    playlist.next();
    playlist.next();
    playlist.next();
    playlist.next();
    playlist.next();
    playlist.next();
    playlist.next();
    playlist.next();

    IO.println(playlist);

    playlist.move(1,2);

    IO.println(playlist);

    playlist.remove(0);

    IO.println(playlist);

    //IO.println(playlist.get(0));
    //IO.println(playlist.get(1));
    //IO.println(playlist.get(2));
    //IO.println(playlist.get(3));




}
