package application;

import javafx.scene.image.Image;

public class AnimatedImage {

	public Image[] frames;
	public double  duration  = 0.1;

		public Image getFrame(double time) {

			int index = (int) ((time%(frames.length*duration))/duration);

			System.out.println(index);

			return frames[index];

		}
		
	

}