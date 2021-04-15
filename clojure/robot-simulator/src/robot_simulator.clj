(ns robot-simulator)

(defn robot [coordinates bearing]
  {:coordinates coordinates
   :bearing bearing})

(defn turn-right [bearing]
  (case bearing
    :west :north
    :north :east
    :south :west
    :east :south))

(defn turn-left [bearing]
  (case bearing
    :north :west
    :east :north
    :west :south
    :south :west))

(defn- advance [old-coordinates bearing]
  (case bearing
    :north (update old-coordinates :y inc)
    :south (update old-coordinates :y dec)
    :east (update old-coordinates :x inc)
    :west (update old-coordinates :x dec)))

(defn- calculate-new-state [{:keys [coordinates bearing] :as old-robot} command]
  (let [new-bearing (case command
                      \R (turn-right bearing)
                      \L (turn-left bearing)
                      bearing)
        new-coordinates (if (= \A command)
                       (advance coordinates bearing)
                       coordinates)]
    (assoc old-robot 
           :bearing new-bearing
           :coordinates new-coordinates)))

(defn simulate [comands robot] ;; <- arglist goes here
  (reduce calculate-new-state robot comands)
)

