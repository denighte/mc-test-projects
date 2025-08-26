package net.kenddie.fantasyarmor.item.armor.lib;

public record FAArmorAttributes(
        double armor,
        double armorToughness,
        double knockbackResistance,
        double movementSpeed,
        double maxHealth,
        double attackDamage,
        double attackSpeed,
        double luck,
        double drawSpeed,
        double expGain,
        double healingReceived,
        double stunArmor,
        double staminaRegen,
        double maxStamina,
        double lifeSteal,
        double critChance,
        double critDamage,
        double overheal
) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private double armor = 0;
        private double armorToughness = 0;
        private double knockbackResistance = 0;
        private double movementSpeed = 0;
        private double maxHealth = 0;
        private double attackDamage = 0;
        private double attackSpeed = 0;
        private double luck = 0;
        private double drawSpeed = 0;
        private double expGain = 0;
        private double healingReceived = 0;
        private double staminaRegen = 0;
        private double maxStamina = 0;
        private double stunArmor = 0;
        private double lifeSteal = 0;
        private double critChance = 0;
        private double critDamage = 0;
        private double overheal = 0;

        public double overheal() {
            return overheal;
        }

        public Builder overheal(double overheal) {
            this.overheal = overheal;
            return this;
        }

        public double critChance() {
            return critChance;
        }

        public Builder critChance(double critChance) {
            this.critChance = critChance;
            return this;
        }

        public double critDamage() {
            return critDamage;
        }

        public Builder critDamage(double critDamage) {
            this.critDamage = critDamage;
            return this;
        }

        public Builder armor(double armor) {
            this.armor = armor;
            return this;
        }

        public Builder stunArmor(double stunArmor) {
            this.stunArmor = stunArmor;
            return this;
        }

        public Builder staminaRegen(double staminaRegen) {
            this.staminaRegen = staminaRegen;
            return this;
        }

        public Builder maxStamina(double maxStamina) {
            this.maxStamina = maxStamina;
            return this;
        }

        public Builder drawSpeed(double drawSpeed) {
            this.drawSpeed = drawSpeed;
            return this;
        }

        public Builder expGain(double expGain) {
            this.expGain = expGain;
            return this;
        }

        public double lifeSteal() {
            return lifeSteal;
        }

        public Builder lifeSteal(double lifeSteal) {
            this.lifeSteal = lifeSteal;
            return this;
        }

        public Builder healingReceived(double healingReceived) {
            this.healingReceived = healingReceived;
            return this;
        }

        public Builder armorToughness(double armorToughness) {
            this.armorToughness = armorToughness;
            return this;
        }

        public Builder knockbackResistance(double knockbackResistance) {
            this.knockbackResistance = knockbackResistance;
            return this;
        }

        public Builder movementSpeed(double movementSpeed) {
            this.movementSpeed = movementSpeed;
            return this;
        }

        public Builder maxHealth(double maxHealth) {
            this.maxHealth = maxHealth;
            return this;
        }

        public Builder attackDamage(double attackDamage) {
            this.attackDamage = attackDamage;
            return this;
        }

        public Builder attackSpeed(double attackSpeed) {
            this.attackSpeed = attackSpeed;
            return this;
        }

        public Builder luck(double luck) {
            this.luck = luck;
            return this;
        }

        public FAArmorAttributes build() {
            return new FAArmorAttributes(
                    armor,
                    armorToughness,
                    knockbackResistance,
                    movementSpeed,
                    maxHealth,
                    attackDamage,
                    attackSpeed,
                    luck,
                    drawSpeed,
                    expGain,
                    healingReceived,
                    stunArmor,
                    staminaRegen,
                    maxStamina,
                    lifeSteal,
                    critChance,
                    critDamage,
                    overheal
            );
        }
    }
}