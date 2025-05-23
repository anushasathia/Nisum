interface MusicPlayer {
    void playMusic();
    void stopMusic();
}


interface Camera {
    void takePicture();
    void recordVideo();
}
class Smartphone implements MusicPlayer, Camera {

   
    @Override
    public void playMusic() {
        System.out.println("🎶 Music is now playing...");
    }

    @Override
    public void stopMusic() {
        System.out.println("⏹️ Music has been stopped.");
    }

    @Override
    public void takePicture() {
        System.out.println("📸 Picture taken!");
    }

    @Override
    public void recordVideo() {
        System.out.println("🎥 Video recording started...");
    }
    public void greetUser() {
        System.out.println("👋 Hello! I'm your Smart Assistant.");
    }
}
public class MultipleInterfaceDemo {
    public static void main(String[] args) {
        Smartphone myPhone = new Smartphone();

        myPhone.greetUser();       
        myPhone.playMusic();       
        myPhone.takePicture();     
        myPhone.recordVideo();     
        myPhone.stopMusic();       
    }
}
