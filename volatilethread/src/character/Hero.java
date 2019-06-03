package character;

public class Hero{
    public String name;
    public volatile float hp;

    public int damage;

    public synchronized void recover(){
        hp=hp+1;
        System.out.printf("t2 为%s 回血1点,增加血后，%s的血量是%.0f%n",name,name,hp);
    }

    public synchronized void hurt(){
        hp=hp-1;
        System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n",name,name,hp);
    }

    public void attackHero(Hero h) {
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }

    public boolean isDead() {
        return 0>=hp?true:false;
    }

}