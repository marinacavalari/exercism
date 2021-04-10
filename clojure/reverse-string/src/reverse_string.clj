(ns reverse-string)

(defn reverse-string [s]
  (->> s
       (reduce conj '())
       (reduce str "")))