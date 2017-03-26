(ns tamagotchi.db
  (:require [tamagotchi.logic :as logic]))

(def default-db
  (->
    (logic/create)
    (assoc :hungriness-color "#00ff00")                     ; green
    (assoc :fullness-color "#00ff00")                       ; green
    (assoc :happiness-color "#00ff00")                      ; green
    (assoc :tiredness-color "#00ff00")                      ; green
    ))
