package es.ieslavereda.oposicion;

public class Main {
    public static void main(String[] args) {

        Bombo bombo;
        Opositor opositor;

        boolean acierto;
        int aciertos = 0;
        int bolas;
        int iteraciones = 1000;
        int temas = 5;

        for(int i=0;i<iteraciones;i++){
            bombo = new Bombo();
            bombo.rellenar();
            bombo.remover();
            acierto=false;
            bolas = 5;
            opositor = new Opositor(temas);
            while (!acierto && bolas>0){
               acierto = opositor.controlaTema(bombo.sacarBola());
               bolas--;
            }
            if(acierto)
                aciertos++;

        }

        System.out.println("Acierto: " +(aciertos/10f)+"%" );






    }
}
