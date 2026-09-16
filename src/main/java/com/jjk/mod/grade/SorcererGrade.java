package com.jjk.mod.grade;

public enum SorcererGrade {
    UNRANKED("UNRANKED", 100, 0.5, 1.0),
    GRADE_4("GRADE_4", 150, 0.7, 1.1),
    GRADE_3("GRADE_3", 200, 0.9, 1.3),
    GRADE_2("GRADE_2", 300, 1.2, 1.5),
    GRADE_1("GRADE_1", 500, 1.5, 1.8),
    SPECIAL_GRADE("SPECIAL_GRADE", 1000, 2.0, 2.5);

    private final String name;
    private final int maxEnergy;
    private final double regenRate;
    private final double damageMultiplier;

    SorcererGrade(String name, int maxEnergy, double regenRate, double damageMultiplier) {
        this.name = name;
        this.maxEnergy = maxEnergy;
        this.regenRate = regenRate;
        this.damageMultiplier = damageMultiplier;
    }

    public String getName() {
        return name;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public double getRegenRate() {
        return regenRate;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public static SorcererGrade fromString(String name) {
        for (SorcererGrade grade : values()) {
            if (grade.name.equals(name)) {
                return grade;
            }
        }
        return UNRANKED;
    }
}
