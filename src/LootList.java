import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LootList {

    private int rollBound = 1000;
    private int rollChangeLegendary = 1;
    private int rollChangeEpic = 10;
    private int rollChangeRare = 100;
    private int rollChangeUncommon = 500;
    private int rollChangeCommon = 750;
    private int rollChangeTrash = 900;

    private List<Item> legendary = new ArrayList<>();
    private List<Item> epic = new ArrayList<>();
    private List<Item> rare = new ArrayList<>();
    private List<Item> uncommon = new ArrayList<>();
    private List<Item> common = new ArrayList<>();
    private List<Item> trash = new ArrayList<>();

    private final Random random = new Random();

    public void addLegendaryItem(Item item) { legendary.add(item); }
    public void addEpicItem(Item item)      { epic.add(item); }
    public void addRareItem(Item item)      { rare.add(item); }
    public void addUnCommonItem(Item item)  {  uncommon.add(item); }
    public void addCommonItem(Item item)    { common.add(item); }
    public void addTrashItem(Item item)     { trash.add(item); }

    // Getters and Setters

    public List<Item> getLegendary(){ return legendary; }
    public List<Item> getEpic()     { return epic; }
    public List<Item> getRare()     { return rare; }
    public List<Item> getUncommon() { return uncommon; }
    public List<Item> getCommon()   { return common; }
    public List<Item> getTrash()    { return trash; }

    public void setLegendary(List<Item> legendary)  { this.legendary = legendary; }
    public void setEpic(List<Item> epic)            { this.epic = epic; }
    public void setRare(List<Item> rare)            { this.rare = rare; }
    public void setUncommon(List<Item> uncommon)    { this.uncommon = uncommon; }
    public void setCommon(List<Item> common)        { this.common = common; }
    public void setTrash(List<Item> trash)          { this.trash = trash; }

    public int getRollBound() { return rollBound; }
    public void setRollBound(int rollBound) { this.rollBound = rollBound; }

    public int getRollChangeLegendary()         { return rollChangeLegendary; }
    public int getRollChangeEpic()              { return rollChangeEpic; }
    public int getRollChangeRare()              { return rollChangeRare; }
    public int getRollChangeUncommon()          { return rollChangeUncommon; }
    public int getRollChangeCommon()            { return rollChangeCommon; }
    public int getRollChangeTrash()             { return rollChangeTrash; }
    public void setRollChangeLegendary(int v)   { this.rollChangeLegendary = v; }
    public void setRollChangeEpic(int v)        { this.rollChangeEpic = v; }
    public void setRollChangeRare(int v)        { this.rollChangeRare = v; }
    public void setRollChangeUncommon(int v)    { this.rollChangeUncommon = v; }
    public void setRollChangeCommon(int v)      { this.rollChangeCommon = v; }
    public void setRollChangeTrash(int v)       { this.rollChangeTrash = v; }

    public Item rollLoot(Enemy enemy) {
        LootList loot = enemy.lootList;
        if (!loot.legendary.isEmpty() && random.nextInt(rollBound) < rollChangeLegendary)
            return loot.rollLegendary();
        if (!loot.epic.isEmpty() && random.nextInt(rollBound) < rollChangeEpic)
            return loot.rollEpic();
        if (!loot.rare.isEmpty() && random.nextInt(rollBound) < rollChangeRare)
            return loot.rollRare();
        if (!loot.uncommon.isEmpty() && random.nextInt(rollBound) < rollChangeUncommon)
            return loot.rollUncommon();
        if (!loot.common.isEmpty() && random.nextInt(rollBound) < rollChangeCommon)
            return loot.rollCommon();
        if (!loot.trash.isEmpty() && random.nextInt(rollBound) < rollChangeTrash)
            return loot.rollTrash();
        return null;
    }

    public Item rollLegendary() { return pick(legendary); }
    public Item rollEpic()      { return pick(epic); }
    public Item rollRare()      { return pick(rare); }
    public Item rollUncommon()  { return pick(uncommon); }
    public Item rollCommon()    { return pick(common); }
    public Item rollTrash()     { return pick(trash); }

    private Item pick(List<Item> list){
        if(list.isEmpty()) return null;
        return list.get(random.nextInt(list.size()));
    }

    // Total useless stuff for debugging

    private String formatList(List<Item> list) {
        if (list.isEmpty()) return "[]";
        return list.stream()
                .map(Item::getName)           // or just .toString() if Item overrides it
                .collect(Collectors.joining(", ", "[\n\t", "\n\t]"));
    }

    @Override
    public String toString() {
        return "LootList{" +
                "legendary= " + formatList(legendary) +
                ",\n epic=" + formatList(epic) +
                ",\n rare=" + formatList(rare) +
                ",\n uncommon=" + formatList(uncommon) +
                ",\n common=" + formatList(common) +
                ",\n trash=" + formatList(trash) +
                '}';
    }
}
