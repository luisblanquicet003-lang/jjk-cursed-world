package com.jjk.mod.mission;

import net.minecraft.nbt.CompoundTag;

public class Mission {
    private String missionId;
    private String missionName;
    private String description;
    private String type;
    private boolean completed;
    private boolean accepted;
    private int rewardExp;
    private int rewardGold;
    private float rewardProgress;

    public Mission(String id, String name, String desc, String type, int exp, int gold) {
        this.missionId = id;
        this.missionName = name;
        this.description = desc;
        this.type = type;
        this.rewardExp = exp;
        this.rewardGold = gold;
        this.completed = false;
        this.accepted = false;
        this.rewardProgress = 0.0f;
    }

    public void accept() {
        this.accepted = true;
    }

    public void complete() {
        this.completed = true;
    }

    public void updateProgress(float amount) {
        this.rewardProgress = Math.min(1.0f, rewardProgress + amount);
    }

    public String getMissionId() {
        return missionId;
    }

    public String getMissionName() {
        return missionName;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public int getRewardExp() {
        return rewardExp;
    }

    public int getRewardGold() {
        return rewardGold;
    }

    public float getRewardProgress() {
        return rewardProgress;
    }

    public CompoundTag save() {
        CompoundTag tag = new CompoundTag();
        tag.putString("MissionId", missionId);
        tag.putString("MissionName", missionName);
        tag.putString("Description", description);
        tag.putString("Type", type);
        tag.putBoolean("Completed", completed);
        tag.putBoolean("Accepted", accepted);
        tag.putInt("RewardExp", rewardExp);
        tag.putInt("RewardGold", rewardGold);
        tag.putFloat("RewardProgress", rewardProgress);
        return tag;
    }

    public void load(CompoundTag tag) {
        if (tag.contains("Completed")) this.completed = tag.getBoolean("Completed");
        if (tag.contains("Accepted")) this.accepted = tag.getBoolean("Accepted");
        if (tag.contains("RewardProgress")) this.rewardProgress = tag.getFloat("RewardProgress");
    }
}
