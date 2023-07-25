class Solution {
    
    public boolean lemonadeChange(int[] bills) {
        // 0: 5$, 1: 10$, 2: 20$
        int[] wallet = new int[3];

        for(int i = 0; i< bills.length; ++i) {
            switch(bills[i]) {
                case 5: {
                    wallet[0]++;
                    break;
                }
                case 10: {
                    wallet[1]++;
                    if(--wallet[0] < 0) return false;
                    break;
                }
                case 20: {
                    wallet[2]++;
                    if (wallet[1] > 0) {
                        if(--wallet[0] < 0 || --wallet[1] < 0) return false;
                    }
                    else {
                        wallet[0] -= 3;
                        if(wallet[0] < 0) return false;
                    }

                    

                    break;
                }
            }
        }
        return true;
    }
}