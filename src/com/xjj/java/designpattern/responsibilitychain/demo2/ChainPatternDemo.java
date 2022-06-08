package com.xjj.java.designpattern.responsibilitychain.demo2;

import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Request;
import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Response;

import java.util.List;

//@Component
public class ChainPatternDemo {

    //�Զ�ע������������Ķ���
//    @Autowired
    private List<AbstractHandler> abstractHandleList;

    private AbstractHandler abstractHandler;

    // springע����Զ�ִ�У��������Ķ�����������
//    @PostConstruct
    public void initializeChainFilter(){
        for(int i = 0;i<abstractHandleList.size();i++){
            if(i == 0){
                abstractHandler = abstractHandleList.get(0);
            }else{
                AbstractHandler currentHander = abstractHandleList.get(i - 1);
                AbstractHandler nextHander = abstractHandleList.get(i);
                currentHander.setNextHandler(nextHander);
            }
        }
    }

    // ֱ�ӵ����������ʹ��
    public Response exec(Request request, Response response) {
        abstractHandler.filter(request, response);
        return response;
    }

    public AbstractHandler getAbstractHandler() {
        return abstractHandler;
    }

    public void setAbstractHandler(AbstractHandler abstractHandler) {
        this.abstractHandler = abstractHandler;
    }

}
