# spring-ai-monitoring

Monitoring Spring AI application

Set the OpenAI API key as an environment variable named OPENAI_API_KEY
```
export OPENAI_API_KEY=your_api_key
```

Run application
```
gradle bootRun
```

Metrics list:
```
http://localhost:9999/actuator/metrics
```

Some metrics related to Spring AI

* gen_ai.client.operation
* gen_ai.client.operation.active
* gen_ai.client.token.usage
* spring.ai.advisor
* spring.ai.advisor.active
* spring.ai.chat.client
* spring.ai.chat.client.active


Query **Spring AI token usage** metric in Prometheus:
```
http://localhost:9090/query?g0.expr=gen_ai_client_token_usage_total&g0.show_tree=0&g0.tab=table&g0.range_input=1h&g0.res_type=auto&g0.res_density=medium&g0.display_mode=lines&g0.show_exemplars=0&g1.expr=&g1.show_tree
```

Grafana
1. Login to Grafana (user/password: admin/admin)
2. Go to Configuration -> Data Sources -> Add data source
3. Add Prometheus data source (Connection field set to http://localhost:9090/)
4. Go to Metrics and in "Search metrics" field type "gen_ai"

You will see the metrics related to Spring AI:
![Alt text](/grafana.png?raw=true "Grafana")