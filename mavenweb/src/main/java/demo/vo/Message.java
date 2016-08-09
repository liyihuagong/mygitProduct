/**
 * 
 */
package demo.vo;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.expression.ParseException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author liyi
 * 
 */
public class Message {
	/**
	 * jackson对重命名的处理
	 */
	@JsonProperty(value = "user_id")
	private String userId; // 用户id

	private String message; // 消息实体

	/**
	 * jackson采用@JsonSerialize和@JsonDeserialize来实现自定义序列化/反序列化的实现
	 */
	@JsonSerialize(using = DemoDateSerializer.class)
	@JsonDeserialize(using = DemoDateDeserializer.class)
	private Date timestamp; // 时间信息, yyyy-MM-dd HH:mm:ss

	/**
	 * 不回传字段
	 */
	@JsonIgnore
	private String extra; // 额外附带信息

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

}

// *) JSON的序列化类
class DemoDateSerializer extends JsonSerializer<Date> {
	@Override 
	public void serialize(Date value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jgen.writeString(dateFormat.format(value));
	}
}

// *) JSON的反序列化类
class DemoDateDeserializer extends JsonDeserializer<Date> {
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext dctx)
			throws IOException, JsonProcessingException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return dateFormat.parse(jp.getValueAsString());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		return null;
	}
}
