(ns tamagotchi.db
  (:require [tamagotchi.logic :as logic]))

(def default-db
  (logic/create))
