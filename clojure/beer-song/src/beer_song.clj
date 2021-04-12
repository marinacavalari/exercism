(ns beer-song)

(def multiple-bottles "%s bottles of beer on the wall, %s bottles of beer.\nTake one down and pass it around, %s bottles of beer on the wall.\n")

(def two-bottles "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n")

(def one-bottle "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n")

(def zero-bottle
  (str "No more bottles of beer on the wall, no more bottles of beer.\n"
       "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (case num
    0 zero-bottle
    1 one-bottle
    2 two-bottles
    (format multiple-bottles num num (dec num))))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start]
   (sing start 0))
  ([start end]
   (loop [i start
          verses ""]
     (cond
       (= i end)
       (recur (dec i)
              (str verses (verse i)))

       (> i end)
       (recur (dec i)
              (str verses (verse i) "\n"))

       :else
       verses))))


