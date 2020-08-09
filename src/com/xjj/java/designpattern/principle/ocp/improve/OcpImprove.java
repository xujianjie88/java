package com.xjj.java.designpattern.principle.ocp.improve;


public class OcpImprove {

    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.draw(new Rectangle());
        graphicEditor.draw(new Circle());
        graphicEditor.draw(new OtherShape());
    }
}

//这是一个画图类【使用方】
class GraphicEditor{
    void draw(Shape s) {
       s.draw();
    }
}

abstract class Shape{
    public abstract void draw();
}

class Rectangle extends Shape{

    @Override
    public void draw() {
        System.out.println("画矩形");
    }
}
class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("画原型");
    }
}

//新增画其他图形
class OtherShape extends Shape{

    @Override
    public void draw() {
        System.out.println("画其他图形");
    }
}
