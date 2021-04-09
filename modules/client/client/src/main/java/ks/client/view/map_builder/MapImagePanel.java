package ks.client.view.map_builder;

import ks.client.view.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MapImagePanel extends JPanel {
    private List<ImageInfo> imageInfoList = new ArrayList<>();

    public MapImagePanel(){
        super();
    }

    @Override
    public void paintComponent(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;

        for (ImageInfo imageInfo: imageInfoList){
            g.drawImage(imageInfo.getBufferedImage(), imageInfo.getX(), imageInfo.getY(), null);
        }
    }

    public void selectImageAt(int mx, int my){
        // deselect all
        imageInfoList.stream().forEach(imageInfo -> imageInfo.setSelected(false));

        // select image
        for (ImageInfo imageInfo: imageInfoList){
            if (imageInfo.contains(mx, my)){
                imageInfo.setSelected(true);
                break;
            }
        }
    }

    public void addImage(String path){
        imageInfoList.add(new ImageInfo(path));
        repaint();
    }

    public void selectedScaleWidth(int newWidth){
        Optional<ImageInfo> selectedImage = imageInfoList.stream().filter(imageInfo -> imageInfo.isSelected()).findFirst();
        if (selectedImage.isPresent()){
            selectedImage.get().scaleWidth(newWidth);
            repaint();
        }
    }

    public void selectedImagePan(int dx, int dy){
        Optional<ImageInfo> selectedImage = imageInfoList.stream().filter(imageInfo -> imageInfo.isSelected()).findFirst();
        if (selectedImage.isPresent()){
            selectedImage.get().pan(dx, dy);
            repaint();
        }
    }

    public static class ImageInfo{
        private String filename;
        private BufferedImage originalBufferedImage;
        private BufferedImage bufferedImage;
        private int x;
        private int y;
        private boolean selected = false;

        public ImageInfo(String filename){
            this.filename = filename;
            this.originalBufferedImage = ImageUtil.get(filename);
            this.bufferedImage = originalBufferedImage;
            this.x = 0;
            this.y = 0;
        }

        public boolean contains(int mx, int my){
            return mx >= x && my >= y && mx < x + this.bufferedImage.getWidth() && my < y + this.bufferedImage.getHeight();
        }

        public void scaleWidth(int newWidth){
            this.bufferedImage = ImageUtil.scaleWidth(this.originalBufferedImage, newWidth);
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public BufferedImage getBufferedImage() {
            return bufferedImage;
        }

        public void setBufferedImage(BufferedImage bufferedImage) {
            this.bufferedImage = bufferedImage;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void pan(int dx, int dy){
            this.x += dx;
            this.y += dy;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }
}
