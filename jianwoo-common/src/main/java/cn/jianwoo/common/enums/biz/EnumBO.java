package cn.jianwoo.common.enums.biz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-21 13:19
 */
public class EnumBO implements Serializable
{
    private static final long serialVersionUID = 4109443717241253364L;

    private String name;
    private String desc;
    private List<Element> list;

    public EnumBO()
    {
        list = new ArrayList<Element>();
    }


    public EnumBO(String name, String desc)
    {
        this.name = name;
        this.desc = desc;
        list = new ArrayList<Element>();
    }


    public List<Element> getList()
    {
        return this.list;
    }


    public void append(String value, String desc)
    {
        this.list.add(new Element(value, desc));
    }


    public void setList(List<Element> list)
    {
        this.list = list;
    }


    public String getName()
    {
        return this.name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getDesc()
    {
        return this.desc;
    }


    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public static class Element
    {
        private String value;
        private String desc;

        public String getValue()
        {
            return this.value;
        }


        public void setValue(String value)
        {
            this.value = value;
        }


        public String getDesc()
        {
            return this.desc;
        }


        public void setDesc(String desc)
        {
            this.desc = desc;
        }


        public Element(String value, String desc)
        {
            this.value = value;
            this.desc = desc;
        }
    }
}
