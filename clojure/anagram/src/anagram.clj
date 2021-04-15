(ns anagram 
  (:require [clojure.string :as string]))

(defn anagrams-for [word prospect-list]
  (let [fixed-word (string/upper-case (sort word))]
    (->> prospect-list
         (filter #(= (string/upper-case (sort %)) fixed-word))
         (map #(apply str %)))))

(anagrams-for "ant" ["tan" "stand" "at"])
(anagrams-for "diaper" ["hello" "world" "zombies" "pants"])



(apply str [\a \b \c])

(str \a \b)

(reverse "world")