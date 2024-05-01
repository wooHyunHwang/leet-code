class ParkingSystem {
    int[] spot;
    public ParkingSystem(int big, int medium, int small) {
        this.spot = new int[4];
        this.spot[1] = big;
        this.spot[2] = medium;
        this.spot[3] = small;
    }
    
    public boolean addCar(int carType) {
        if (this.spot[carType] < 1) return false;
        this.spot[carType]--;
        return true;
    }
} 
/* 8ms
class ParkingSystem {
    int big = 0, medium = 0, small = 0;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        switch (carType) {
            case 1 : {
                if (this.big < 1) return false;
                this.big--;
                break;
            }
            case 2 : {
                if (this.medium < 1) return false;
                this.medium--;
                break;
            }
            case 3 : {
                if (this.small < 1) return false;
                this.small--;
                break;
            }
        }
        return true;
    }
}
*/
/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */