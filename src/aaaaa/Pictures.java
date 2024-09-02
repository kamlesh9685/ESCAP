package aaaaa;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Pictures {
	ArrayList frame;
	int currFrame;
    boolean picLoop;
	private long picTime;
	private long Duration;

	public Pictures(boolean l) {
        picLoop = l;
		frame = new ArrayList();
		Duration = 0;

		synchronized (this) {
			picTime = 0;
			currFrame = 0;
		}
	}

	public synchronized void addFrame(BufferedImage image, long duration) {
		Duration += duration;
		frame.add(new picFrame(image, Duration));
	}

	public synchronized void update(long elapsedTime) {
           
		if (frame.size() > 1) {
			picTime += elapsedTime;
                                
                if (!(picLoop && currFrame == frame.size()-1)){
                    if (picTime >= Duration) {
                            picTime = picTime % Duration;
                            currFrame = 0;
						}
                        while (picTime > getFrame(currFrame).endTime) {
                            currFrame++;
                        }
                }
            }
		}

	public synchronized BufferedImage getImage() {
		if (frame.size() == 0) {
			return null;
		} else {
			return getFrame(currFrame).image;
		}
	}

	private picFrame getFrame(int i) {
		return (picFrame) frame.get(i);
	}

	private class picFrame {
		BufferedImage image;
		long endTime;

		public picFrame(Image image, long endTime) {
			this.image = (BufferedImage) image;
			this.endTime = endTime;
		}
	}
}