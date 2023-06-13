class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        var lastIdx = -1

        for(i in 0..asteroids.size - 1) {
            var processed = false

            while(!processed && asteroids[i] < 0 && lastIdx >= 0 && asteroids[lastIdx] > 0) {
                processed = asteroids[lastIdx] + asteroids[i] >= 0
                if(asteroids[lastIdx] + asteroids[i] <= 0) lastIdx--
            }

            if(!processed) asteroids[++lastIdx] = asteroids[i]
        }

        return asteroids.slice(0..lastIdx).toIntArray()
        
    }
}