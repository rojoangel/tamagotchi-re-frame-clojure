(ns tamagotchi-web.color
  (:require [tamagotchi-web.logic :as tamagotchi]))

(def color-map
  {:red "#ff0000"
   :yellow "#ff9d00"
   :green "#00ff00"})

(defmulti value->color :type)

(defmethod value->color :decreasing [{type :type value :val} kw->color-fn]
  (if (< value (* tamagotchi/max-attribute-value 0.1))
    (kw->color-fn :red)
    (if (< value (* tamagotchi/max-attribute-value 0.25))
      (kw->color-fn :yellow)
      (kw->color-fn :green))))

(defmethod value->color :increasing [{type :type value :val} kw->color-fn]
  (if (> value (* tamagotchi/max-attribute-value 0.9))
    (kw->color-fn :red)
    (if (> value (* tamagotchi/max-attribute-value 0.75))
      (kw->color-fn :yellow)
      (kw->color-fn :green))))