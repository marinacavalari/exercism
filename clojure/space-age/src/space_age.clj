(ns space-age)

(defn on-earth [seconds]
  (/ seconds 31557600))

(defn on-mercury [seconds]
  (->> (/ seconds 0.2408467)
       on-earth))

(defn on-venus [seconds]
  (->> (/ seconds 0.61519726)
       on-earth))

(defn on-mars [seconds] 
  (->> (/ seconds 1.8808158)
       on-earth))

(defn on-jupiter [seconds]
  (->> (/ seconds 11.862615)
       on-earth))

(defn on-saturn [seconds] 
  (->> (/ seconds 29.447498)
       on-earth))

(defn on-neptune [seconds]
  (->> (/ seconds 164.79132)
       on-earth))

(defn on-uranus [seconds] 
  (->> (/ seconds 164.79132)
       on-earth))




