(ns allergies)

(defn pow-2 [n]
  (apply * (repeat n 2)))

(def alergics
  {128 :cats
   64 :pollen
   32 :chocolate
   16 :tomatoes
   8 :strawberries
   4 :shellfish
   2 :peanuts
   1 :eggs})

(get alergics 1)

(defn allergies [id]
  (->> (mod id 256)
       Integer/toBinaryString
       Integer/parseInt
       (format "%08d")
       reverse
       (map-indexed (fn [i el]
                      (when (= el \1)
                        (get alergics (pow-2 i)))))
       (remove nil?)
       vec))

(defn allergic-to? [id alergic]
  (some #(= alergic %) (allergies id)))
