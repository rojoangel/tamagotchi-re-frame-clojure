(ns tamagotchi-web.db
  (:require [tamagotchi-web.logic :as logic]))

(def default-db
  (logic/create))
