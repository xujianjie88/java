package com.xjj.java.designpattern.principle.ocp;


/**
 * 开闭原则
 */
public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
    }
}


class GraphicEditor{
    //接受Shape对象，然后根据type，来绘制不同的图形
    public void drawShape(Shape s){
        if(s.type==1)
            drawRectangle(s);
        else if(s.type==2)
            drawCircle(s);

    }

    private void drawCircle(Shape s) {
        System.out.println("画圆形");
    }

    private void drawRectangle(Shape s) {
        System.out.println("画矩形");
    }
}

class Shape{
    int type;
}


class Rectangle extends Shape{
    Rectangle(){
        super.type=1;
    }
}
class Circle extends Shape{
    Circle(){
        super.type=2;
    }
}


