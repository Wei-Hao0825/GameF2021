import java.awt.*;
import java.net.URL;

public class Animation
{
    Image[] image;

    int delay;

    int current = 0;

    final int duration;

    public Animation (String name, String fileType, int count, int delay)
    {
        image = new Image[count];

        for (int i = 0; i < count; i++)
        {

            URL imgUrl = getClass().getResource("image/" + name + i + "." + fileType); // resource name here
            image[i] = Toolkit.getDefaultToolkit().getImage(imgUrl);
        }

        this.delay = delay;
        this.duration = delay;
    }


    public Image currentImage()
    {
        delay--;
        if(delay == 0)
        {
            if(current < image.length - 1) current++;
            else current = 1;
            delay = duration;
        }
        return image[current];
    }

}
