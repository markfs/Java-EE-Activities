/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity2;

import java.util.LinkedList;

/**
 *
 * @author Mark
 */
public class Hero {
    private String strName;
    private String strType;
    private int iCurrSkill;
    protected LinkedList skills;
    
    public Hero(String strName, String strType)
    {
        this.strName = strName;
        this.strType = strType;
        skills = new LinkedList();
    }
    
    public void attack()
    {
        System.out.println("Attacking with '"+ skills.get(iCurrSkill)+"'");
    }

    public void attack(String strSkill)
    {
        if(skills.contains(strSkill))
        {
            this.iCurrSkill = skills.indexOf(strSkill);
            System.out.println("Attacking with '"+ strSkill +"'");
        }
        else
            System.out.println("Skill not on the skill list. Add the skill first.");
    }
    
    public void block()
    {
        System.out.println("Blocking with '"+ skills.get(iCurrSkill)+"'");
    }
    
    public void block(String strSkill)
    {
        if(skills.contains(strSkill))
        {
            this.iCurrSkill = skills.indexOf(strSkill);
            System.out.println("Blocking with '"+ strSkill +"'");
        }
        else
            System.out.println("Skill not on the skill list. Add the skill first.");
    }
    
    public void addSkill(String strNewSkill)
    {
        skills.add(strNewSkill);
        if(skills.size() == 1)
            this.iCurrSkill = skills.indexOf(strNewSkill);
    }
    
    /* Sets the current skill of the hero */
    public void setCurrentSkill(String strNewCurrSkill)
    {
        int index = skills.indexOf(strNewCurrSkill);
        if(index == -1)
            System.out.println("Skill not on the skill list. Add the skill first.");
        else
            this.iCurrSkill = index;
    }
    
    public void choose()
    {
        System.out.println("Choosing '"+ this.strName +"'");
    }
    
    /* Setters and Getters */
    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrType() {
        return strType;
    }

    public void setStrType(String strType) {
        this.strType = strType;
    }

    public int getiCurrSkill() {
        return iCurrSkill;
    }

    public void setiCurrSkill(int iCurrSkill) {
        this.iCurrSkill = iCurrSkill;
    }
}
