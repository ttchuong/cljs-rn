(ns awesome-project.core
  (:require
   ["../hello" :as hello]
   ["react" :as r]
   ["react-native" :as rn]
   ["react-native-date-picker$default" :as dp]
   [awesome-project.platform :as p]
   [shadow.react-native :refer (render-root)]))

(defn hello []
  (r/useEffect (fn []
                 (js/console.log "OK")
                 (constantly nil))
               #js [])
  (r/createElement
   rn/View
   nil
   (r/createElement rn/Text nil "Helloo")
   (r/createElement dp (clj->js {:date (js/Date.)
                                 :onDateChange (fn [new-date]
                                                 (js/alert new-date))}))
   (r/createElement rn/Image (clj->js {:source (js/require "../assets/shadow-cljs.png")}))))

(defn start
  {:dev/after-load true}
  []
  (p/print-platform)
  (render-root "AwesomeProject" (r/createElement hello)))

(defn init []
  (start))
