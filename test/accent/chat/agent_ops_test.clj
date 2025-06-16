(ns accent.chat.agent-ops-test
  (:require [clojure.test :refer :all]
            [accent.chat :refer [->OpenAIProvider ->OpenRouterProvider tool-time get-model switch-model create-agent]]))


(deftest agent-ops-test
  (testing "get-model returns current model"
    (let [provider (->OpenAIProvider "gpt-4o" (atom []) nil tool-time (atom {}))]
      (is (= "gpt-4o" (get-model provider)))))
  
  (testing "switch-model changes the model"
    (let [provider (->OpenAIProvider "gpt-4o" (atom []) nil tool-time (atom {}))]
      (switch-model provider "gpt-3.5-turbo")
      (is (= "gpt-3.5-turbo" (get-model provider))))))

(deftest openrouter-agent-ops-test
  (testing "OpenRouter provider get-model returns current model"
    (let [provider (->OpenRouterProvider "openai/gpt-4o" (atom []) nil tool-time (atom {}))]
      (is (= "openai/gpt-4o" (get-model provider)))))
  
  (testing "OpenRouter provider switch-model changes the model"
    (let [provider (->OpenRouterProvider "openai/gpt-4o" (atom []) nil tool-time (atom {}))]
      (switch-model provider "anthropic/claude-3.7-sonnet")
      (is (= "anthropic/claude-3.7-sonnet" (get-model provider))))))

(deftest create-agent-test
  (testing "create-agent with OpenRouter provider"
    (let [agent-config {:provider :openrouter
                        :model "openai/gpt-4o"
                        :role "You are a helpful assistant"
                        :tools []}
          agent (create-agent agent-config)]
      (is (= "openai/gpt-4o" (get-model agent))))))
